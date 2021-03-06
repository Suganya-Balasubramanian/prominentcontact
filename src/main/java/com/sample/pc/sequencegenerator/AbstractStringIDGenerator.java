package com.sample.pc.sequencegenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public abstract class AbstractStringIDGenerator implements IdentifierGenerator, Configurable {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractStringIDGenerator.class);

	public static final String SEQUENCE_PREFIX = "sequence_prefix";
	public static final String SEQUENCE_PREFIX_INCREMENT = "sequence_increment";

	public final String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";
	private final String BLANK_SPACE = " ";
	public String sequencePrefix_seperator = ENTITY_KEY_CODE.SEQUENCE_PREFIX_SEPERATOR;
	public String globalDefaultEntityIdentifierPrefix = "SYS";
	public String sequencePrefix;
	public int sequence_increment = 1;

	public abstract String defaultEntityIdentifierPrefix();

	public abstract boolean isStringFormatDecimal();

	public abstract String getStringFormat();

	public abstract boolean isAssignedSequence();

	public AbstractStringIDGenerator() {
		super();
	}

	@SuppressWarnings("unused")
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		final JdbcEnvironment jdbcEnvironment = serviceRegistry.getService(JdbcEnvironment.class);

		final ConfigurationService configurationService = serviceRegistry.getService(ConfigurationService.class);

		String globalEntityIdentifierPrefix = configurationService.getSetting("entity.identifier.prefix", String.class,
				globalDefaultEntityIdentifierPrefix + sequencePrefix_seperator);

		sequencePrefix = ConfigurationHelper.getString(SEQUENCE_PREFIX, params, globalEntityIdentifierPrefix)
				+ sequencePrefix_seperator;

		sequence_increment = ConfigurationHelper.getInteger(SEQUENCE_PREFIX_INCREMENT, params);

		final String sequencePerEntitySuffix = ConfigurationHelper.getString(
				SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, params,
				SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX);

		final String defaultSequenceName = ConfigurationHelper
				.getBoolean(SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, params, false)
						? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
						: SequenceStyleGenerator.DEF_SEQUENCE_NAME;

	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		try {
			if (object instanceof Identifiable) {
				Identifiable<?> identifiable = (Identifiable<?>) object;
				Serializable id = identifiable.getId();
				String prefix = (String) identifiable.getPrefix();
				if (prefix != null && !prefix.isEmpty()) {
					sequencePrefix = (String) prefix + sequencePrefix_seperator;
				} else {
					sequencePrefix = defaultEntityIdentifierPrefix() + sequencePrefix_seperator;
				}
				if (id != null) {
					return id;
				}
			}
			return generateAlphanumericID(session, sequencePrefix, sequence_increment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Generate alphanumeric id from hibernate session with prefix
	 * 
	 * @param session
	 * @param prefix
	 * @param sequence_increment
	 * @return
	 */
	private synchronized Serializable generateAlphanumericID(SharedSessionContractImplementor session, String prefix,
			int sequence_increment) {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			int nextValue = 0;
			int start_val = 0;

			connection = session.connection();
			statement = connection.createStatement();
			try {
				resultSet = statement.executeQuery(selectSEQTable(prefix));
			} catch (Exception e) {
				log.debug("In catch, cause : Table is not available.");
				statement.execute(createSEQTable());
				statement.executeUpdate(insertSEQTable(prefix, start_val, sequence_increment));
				statement.executeUpdate(updateSEQTable(prefix));
				resultSet = statement.executeQuery(selectSEQTable(prefix));
			}

			if (resultSet.next()) {
				statement.executeUpdate(updateSEQTable(prefix));
				ResultSet resultSetIdentify = statement.executeQuery(selectSEQTable(prefix));
				if (resultSetIdentify.next()) {
					nextValue = resultSetIdentify.getInt(1);
					result = buildStringNextValue(prefix, nextValue);
				}
			} else {
				statement.executeUpdate(insertSEQTable(prefix, start_val, sequence_increment));
				statement.executeUpdate(updateSEQTable(prefix));
				ResultSet resultSetIdentify = statement.executeQuery(selectSEQTable(prefix));
				if (resultSetIdentify.next()) {
					nextValue = resultSetIdentify.getInt(1);
					result = buildStringNextValue(prefix, nextValue);
				}
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			statement = null;
			resultSet = null;
			connection = null;
		}
		return result;
	}

	/**
	 * Build the string from prefix , concat char and next value
	 * 
	 * @param prefix
	 * @param nextValue
	 * @return
	 */
	private Serializable buildStringNextValue(String prefix, int nextValue) {
		Serializable result = null;
		String suffix = null;
		if (isStringFormatDecimal()) {
			if (getStringFormat() != null)
				suffix = String.format(getStringFormat(), nextValue);
			else
				suffix = String.format("%018d", nextValue);

			result = prefix.concat(suffix);
		} else {
			suffix = String.valueOf(nextValue);
			result = prefix.concat(suffix);
		}
		log.debug("Custom generated sequence is : " + result);
		return result;
	}

	/**
	 * Get the sql script for hibernate sequence next value
	 * 
	 * @param prefix
	 * @return
	 */
	private String selectSEQTable(String prefix) {
		StringBuffer buildSQL = new StringBuffer();
		buildSQL.append("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME + BLANK_SPACE);
		buildSQL.append("WHERE prefix_value ='" + prefix + "'");
		return buildSQL.toString();
	}

	/**
	 * Get the update table script for hibernate sequence
	 * 
	 * @param prefix
	 * @return
	 */
	private String updateSEQTable(String prefix) {
		StringBuffer buildSQL = new StringBuffer();
		buildSQL.append("UPDATE " + DEFAULT_SEQUENCE_NAME + BLANK_SPACE);
		buildSQL.append("SET next_val = ( next_val + increment ) ");
		buildSQL.append("WHERE prefix_value ='" + prefix + "'");
		// --log.debug(buildSQL.toString());
		return buildSQL.toString();
	}

	/**
	 * Get the insert table script for hibernate sequence
	 * 
	 * @param prefix
	 * @param start_val
	 * @param increment
	 * @return
	 */
	private String insertSEQTable(String prefix, int start_val, int increment) {
		StringBuffer buildSQL = new StringBuffer();
		buildSQL.append("INSERT INTO " + DEFAULT_SEQUENCE_NAME + BLANK_SPACE);
		buildSQL.append("( prefix_value,next_val,increment ) VALUES ");
		buildSQL.append("('" + prefix + "'," + start_val + "," + increment + ") ");
		// --log.debug(buildSQL.toString());
		return buildSQL.toString();
	}

	/**
	 * Get the create table script for hibernate sequence.
	 * 
	 * @return
	 */
	private String createSEQTable() {
		StringBuffer buildSQL = new StringBuffer();
		buildSQL.append(" CREATE TABLE " + DEFAULT_SEQUENCE_NAME + " ( ");
		buildSQL.append("id bigint(20) NOT NULL AUTO_INCREMENT, ");
		buildSQL.append("prefix_value varchar(12) NOT NULL, ");
		buildSQL.append("next_val int(11) NOT NULL, ");
		buildSQL.append("increment int(11) NOT NULL, ");
		buildSQL.append("PRIMARY KEY (id) ");
		buildSQL.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
		// --log.debug(buildSQL.toString());
		return buildSQL.toString();
	}

	/**
	 * Default id generations
	 * 
	 * @param sequencePrefix
	 * @return
	 */
	private String getUniqueIDWithDateTimeBased(String sequencePrefix) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-MM-mm-ss");
		return sequencePrefix + "-" + simpleDateFormat.format(new Date());
	}
}
