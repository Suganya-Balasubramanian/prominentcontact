package com.sample.pc.sequencegenerator;

public class Main1IDGenerator extends AbstractStringIDGenerator {

	public static final String defaultsSequencePrefix = ENTITY_KEY_CODE.KEY_MAIN1;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%010d";

	public Main1IDGenerator() {
		super();
	}

	
	@Override
	public String defaultEntityIdentifierPrefix() {
		return defaultsSequencePrefix;
	}

	@Override
	public boolean isStringFormatDecimal() {
		return false;
	}

	@Override
	public String getStringFormat() {
		// --String.format("%010d", nextValue);
		return stringFormat;
	}

	@Override
	public boolean isAssignedSequence() {
		return false;
	}
}