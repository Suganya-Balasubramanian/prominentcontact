package com.sample.pc.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sample.pc.sequencegenerator.Identifiable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "full_name",
    "first_name",
    "middle_initial",
    "middle_name",
    "last_name",
    "gender",
    "birth_year",
    "birth_date",
    "linkedin_url",
    "linkedin_username",
    "linkedin_id",
    "facebook_url",
    "facebook_username",
    "facebook_id",
    "twitter_url",
    "twitter_username",
    "github_url",
    "github_username",
    "work_email",
    "mobile_phone",
    "industry",
    "job_title",
    "job_title_role",
    "job_title_sub_role",
    "job_title_levels",
    "job_company_id",
    "job_company_name",
    "job_company_website",
    "job_company_size",
    "job_company_founded",
    "job_company_industry",
    "job_company_linkedin_url",
    "job_company_linkedin_id",
    "job_company_facebook_url",
    "job_company_twitter_url",
    "job_company_location_name",
    "job_company_location_locality",
    "job_company_location_region",
    "job_company_location_geo",
    "job_company_location_street_address",
    "job_company_location_address_line_2",
    "job_company_location_postal_code",
    "job_company_location_country",
    "job_company_location_continent",
    "job_last_updated",
    "job_start_date",
    "job_summary",
    "location_name",
    "location_locality",
    "location_region",
    "location_country",
    "location_continent",
    "location_street_address",
    "location_address_line_2",
    "location_postal_code",
    "location_geo",
    "location_last_updated",
    "inferred_salary",
    "inferred_years_experience",
    "summary",
    "phone_numbers",
    "emails",
    "interests",
    "skills",
    "location_names",
    "regions",
    "countries",
    "street_addresses",
    "experience",
    "education",
    "profiles",
    "version_status"
})


@Entity
public class Main1 implements Serializable{	
	
		private static final long serialVersionUID = 180752390917648980L;
		@Id
//		@GenericGenerator(name = "main1_string_id_generator", strategy = "com.sample.pc.sequencegenerator.Main1IDGenerator", 
//		parameters = { @org.hibernate.annotations.Parameter(name = "sequence_prefix", value = Main1IDGenerator.defaultsSequencePrefix),
//		@org.hibernate.annotations.Parameter(name = "sequence_increment", value = Main1IDGenerator.defaultSsequenceIncrement) })
//		@GeneratedValue(generator = "main1_string_id_generator")
		
		@GeneratedValue( strategy = GenerationType.IDENTITY )
	    @JsonIgnore
		private Long id;
		
		@JsonProperty("id")		
	    private String jsonId;
		@JsonProperty("full_name")
	    private String fullName;
		@JsonProperty("first_name")
	    private String firstName;
		@JsonProperty("middle_initial")
	    private String middleInitial;
		@JsonProperty("middle_name")
	    private String middleName;
		@JsonProperty("last_name")
	    private String lastName;
		@JsonProperty("gender")
	    private String gender;
		@JsonProperty("birth_year")
	    private String birthYear;
		@JsonProperty("birth_date")
	    private String birthDate;
		@JsonProperty("linkedin_url")
	    private String linkedinUrl;	
		@JsonProperty("linkedin_username")
	    private String linkedinUsername;
		@JsonProperty("linkedin_id")
	    private String linkedinId;
		@JsonProperty("facebook_url")
	    private String facebookUrl;	
		
		@JsonProperty("facebook_username")
	    private String facebookUsername;
		
		@JsonProperty("facebook_id")
	    private String facebookId;
		
		@JsonProperty("twitter_url")
	    private String twitterUrl;
		
		@JsonProperty("twitter_username")
	   	private String twitterUsername;	
		
		@JsonProperty("github_url")
	    private String githubUrl;
		
		@JsonProperty("github_username")
	    private String githubUsername;
		
		@JsonProperty("work_email")
	    private String workEmail;
	    
	    @JsonProperty("mobile_phone")
	    private String mobilePhone;	
	    
	    @JsonProperty("industry")
	    private String industry;
	    
	    @JsonProperty("job_title")
	    private String jobTitle;
	    
	    @JsonProperty("job_title_role")
	    private String jobTitleRole;
	    
	    @JsonProperty("job_title_sub_role")
	    private String jobTitleSubRole;
	    
	    @JsonProperty("job_title_levels")
	    @ElementCollection
	    private List<String> jobTitleLevels = null;
	    
	    @JsonProperty("job_company_id")
	    private String jobCompanyId;
	    
	    @JsonProperty("job_company_name")
	    private String jobCompanyName;
	    
	    @JsonProperty("job_company_website")
	    private String jobCompanyWebsite;
	    
	    @JsonProperty("job_company_size")
	    private String jobCompanySize;
	    
	    @JsonProperty("job_company_founded")
	    private String jobCompanyFounded;
	    
	    @JsonProperty("job_company_industry")
	    private String jobCompanyIndustry;
	    
	    @JsonProperty("job_company_linkedin_url")
	    private String jobCompanyLinkedinUrl;
	    
	    @JsonProperty("job_company_linkedin_id")
	    private String jobCompanyLinkedinId;
	    
	    @JsonProperty("job_company_facebook_url")
	    private String jobCompanyFacebookUrl;
	    
	    @JsonProperty("job_company_twitter_url")
	    private String jobCompanyTwitterUrl;
	    
	    @JsonProperty("job_company_location_name")
	    private String jobCompanyLocationName;
	    
	    @JsonProperty("job_company_location_locality")
	    private String jobCompanyLocationLocality;
	    
	    @JsonProperty("job_company_location_region")
	   	private String jobCompanyLocationRegion;
	    
	    @JsonProperty("job_company_location_geo")
	    private String jobCompanyLocationGeo;
	    
	    @JsonProperty("job_company_location_street_address")
	    private String jobCompanyLocationStreetAddress;	
	    
	    @JsonProperty("job_company_location_address_line_2")
	    private String jobCompanyLocationAddressLine2;
	    
	    @JsonProperty("job_company_location_postal_code")
	    private String jobCompanyLocationPostalCode;
	    
	    @JsonProperty("job_company_location_country")
	    private String jobCompanyLocationCountry;
	    
	    @JsonProperty("job_company_location_continent")
	    private String jobCompanyLocationContinent;	
	    
	    @JsonProperty("job_last_updated")
	    private String jobLastUpdated;
	    
	    @JsonProperty("job_start_date")
	    private String jobStartDate;
	    
	    @JsonProperty("job_summary")
	    private String jobSummary;	
	    
	    @JsonProperty("location_name")
	    private String locationName;
	    
	    @JsonProperty("location_locality")
	    private String locationLocality;
	    
	    @JsonProperty("location_region")	    
	    private String locationRegion;	
	    
	    @JsonProperty("location_country")
	    private String locationCountry;	
	    
	    @JsonProperty("location_continent")
	    private String locationContinent;
	    
	    @JsonProperty("location_street_address")
	    private String locationStreetAddress;
	    
	    @JsonProperty("location_address_line_2")
	    private String locationAddressLine2;
	    
	    @JsonProperty("location_postal_code")
	    private String locationPostalCode;
	    
	    @JsonProperty("location_geo")
	    private String locationGeo;	 
	    
	    @JsonProperty("location_last_updated")
	    private String locationLastUpdated;
	    
	    @JsonProperty("inferred_salary")
	    private String inferredSalary;	
	    
	    @JsonProperty("inferred_years_experience") 
	    private Integer inferredYearsExperience;
	    
	    @JsonProperty("summary")
	    private String summary;	
	    
	    @JsonProperty("phone_numbers")
	    @ElementCollection
	    private List<String> phone = null;
	    
	    @JsonProperty("emails") 
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="main1_email", joinColumns={@JoinColumn(name="main1_sno", referencedColumnName="id")}
	    , inverseJoinColumns={@JoinColumn(name="email_sno", referencedColumnName="sno")})
	    private List<Email> emails = null;	
	    
	    @JsonProperty("interests")
	    @ElementCollection
	    private List<String> interests = null;
	    
	    @JsonProperty("skills")		   
	    @ElementCollection
	    private List<String> skills = null;	
	    
	    @JsonProperty("location_names")	   
	    @ElementCollection
	    private List<String> locationNames = null;
	    
	    @JsonProperty("regions")	    
	    @ElementCollection
	    private List<String> regions = null;	
	    
	    @JsonProperty("countries")	    
	    @ElementCollection
	    private List<String> countries = null;
	    
	    @JsonProperty("street_addresses")	    
	    @ElementCollection
	    private List<String> streetAddresses = null;
	    
	    @JsonProperty("experience")
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="main1_experience", joinColumns={@JoinColumn(name="main1_sno", referencedColumnName="id")}
	    , inverseJoinColumns={@JoinColumn(name="experience_sno", referencedColumnName="sno")})
	    private List<Experience> experience = null; 	    
	    
	    @JsonProperty("education")	
	    @ElementCollection
	    private List<String> education = null;
	    
	    @JsonProperty("profiles")
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="main1_profile", joinColumns={@JoinColumn(name="main1_sno", referencedColumnName="id")}
	    , inverseJoinColumns={@JoinColumn(name="profile_sno", referencedColumnName="sno")})
	    private List<Profile> profiles = null;
	    
	    @JsonProperty("version_status")
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinTable(name="main1_version_status", joinColumns = @JoinColumn(name="main1_sno"),
	    inverseJoinColumns = @JoinColumn(name="version_status_sno"))
	    private VersionStatus versionStatus;
	    
	 
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getJsonId() {
			return jsonId;
		}

		public void setJsonId(String jsonId) {
			this.jsonId = jsonId;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleInitial() {
			return middleInitial;
		}

		public void setMiddleInitial(String middleInitial) {
			this.middleInitial = middleInitial;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getBirthYear() {
			return birthYear;
		}

		public void setBirthYear(String birthYear) {
			this.birthYear = birthYear;
		}

		public String getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}

		public String getLinkedinUrl() {
			return linkedinUrl;
		}

		public void setLinkedinUrl(String linkedinUrl) {
			this.linkedinUrl = linkedinUrl;
		}

		public String getLinkedinUsername() {
			return linkedinUsername;
		}

		public void setLinkedinUsername(String linkedinUsername) {
			this.linkedinUsername = linkedinUsername;
		}

		public String getLinkedinId() {
			return linkedinId;
		}

		public void setLinkedinId(String linkedinId) {
			this.linkedinId = linkedinId;
		}

		public String getFacebookUrl() {
			return facebookUrl;
		}

		public void setFacebookUrl(String facebookUrl) {
			this.facebookUrl = facebookUrl;
		}

		public String getFacebookUsername() {
			return facebookUsername;
		}

		public void setFacebookUsername(String facebookUsername) {
			this.facebookUsername = facebookUsername;
		}

		public String getFacebookId() {
			return facebookId;
		}

		public void setFacebookId(String facebookId) {
			this.facebookId = facebookId;
		}

		public String getTwitterUrl() {
			return twitterUrl;
		}

		public void setTwitterUrl(String twitterUrl) {
			this.twitterUrl = twitterUrl;
		}

		public String getTwitterUsername() {
			return twitterUsername;
		}

		public void setTwitterUsername(String twitterUsername) {
			this.twitterUsername = twitterUsername;
		}

		public String getGithubUrl() {
			return githubUrl;
		}

		public void setGithubUrl(String githubUrl) {
			this.githubUrl = githubUrl;
		}

		public String getGithubUsername() {
			return githubUsername;
		}

		public void setGithubUsername(String githubUsername) {
			this.githubUsername = githubUsername;
		}

		public String getWorkEmail() {
			return workEmail;
		}

		public void setWorkEmail(String workEmail) {
			this.workEmail = workEmail;
		}

		public String getMobilePhone() {
			return mobilePhone;
		}

		public void setMobilePhone(String mobilePhone) {
			this.mobilePhone = mobilePhone;
		}

		public String getIndustry() {
			return industry;
		}

		public void setIndustry(String industry) {
			this.industry = industry;
		}

		public String getJobTitle() {
			return jobTitle;
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		public String getJobTitleRole() {
			return jobTitleRole;
		}

		public void setJobTitleRole(String jobTitleRole) {
			this.jobTitleRole = jobTitleRole;
		}

		public String getJobTitleSubRole() {
			return jobTitleSubRole;
		}

		public void setJobTitleSubRole(String jobTitleSubRole) {
			this.jobTitleSubRole = jobTitleSubRole;
		}

		public String getJobCompanyId() {
			return jobCompanyId;
		}

		public void setJobCompanyId(String jobCompanyId) {
			this.jobCompanyId = jobCompanyId;
		}

		public String getJobCompanyName() {
			return jobCompanyName;
		}

		public void setJobCompanyName(String jobCompanyName) {
			this.jobCompanyName = jobCompanyName;
		}

		public String getJobCompanyWebsite() {
			return jobCompanyWebsite;
		}

		public void setJobCompanyWebsite(String jobCompanyWebsite) {
			this.jobCompanyWebsite = jobCompanyWebsite;
		}

		public String getJobCompanySize() {
			return jobCompanySize;
		}

		public void setJobCompanySize(String jobCompanySize) {
			this.jobCompanySize = jobCompanySize;
		}

		public String getJobCompanyFounded() {
			return jobCompanyFounded;
		}

		public void setJobCompanyFounded(String jobCompanyFounded) {
			this.jobCompanyFounded = jobCompanyFounded;
		}

		public String getJobCompanyIndustry() {
			return jobCompanyIndustry;
		}

		public void setJobCompanyIndustry(String jobCompanyIndustry) {
			this.jobCompanyIndustry = jobCompanyIndustry;
		}

		public String getJobCompanyLinkedinUrl() {
			return jobCompanyLinkedinUrl;
		}

		public void setJobCompanyLinkedinUrl(String jobCompanyLinkedinUrl) {
			this.jobCompanyLinkedinUrl = jobCompanyLinkedinUrl;
		}

		public String getJobCompanyLinkedinId() {
			return jobCompanyLinkedinId;
		}

		public void setJobCompanyLinkedinId(String jobCompanyLinkedinId) {
			this.jobCompanyLinkedinId = jobCompanyLinkedinId;
		}

		public String getJobCompanyFacebookUrl() {
			return jobCompanyFacebookUrl;
		}

		public void setJobCompanyFacebookUrl(String jobCompanyFacebookUrl) {
			this.jobCompanyFacebookUrl = jobCompanyFacebookUrl;
		}

		public String getJobCompanyTwitterUrl() {
			return jobCompanyTwitterUrl;
		}

		public void setJobCompanyTwitterUrl(String jobCompanyTwitterUrl) {
			this.jobCompanyTwitterUrl = jobCompanyTwitterUrl;
		}

		public String getJobCompanyLocationName() {
			return jobCompanyLocationName;
		}

		public void setJobCompanyLocationName(String jobCompanyLocationName) {
			this.jobCompanyLocationName = jobCompanyLocationName;
		}

		public String getJobCompanyLocationLocality() {
			return jobCompanyLocationLocality;
		}

		public void setJobCompanyLocationLocality(String jobCompanyLocationLocality) {
			this.jobCompanyLocationLocality = jobCompanyLocationLocality;
		}

		public String getJobCompanyLocationRegion() {
			return jobCompanyLocationRegion;
		}

		public void setJobCompanyLocationRegion(String jobCompanyLocationRegion) {
			this.jobCompanyLocationRegion = jobCompanyLocationRegion;
		}

		public String getJobCompanyLocationGeo() {
			return jobCompanyLocationGeo;
		}

		public void setJobCompanyLocationGeo(String jobCompanyLocationGeo) {
			this.jobCompanyLocationGeo = jobCompanyLocationGeo;
		}

		public String getJobCompanyLocationStreetAddress() {
			return jobCompanyLocationStreetAddress;
		}

		public void setJobCompanyLocationStreetAddress(String jobCompanyLocationStreetAddress) {
			this.jobCompanyLocationStreetAddress = jobCompanyLocationStreetAddress;
		}

		public String getJobCompanyLocationAddressLine2() {
			return jobCompanyLocationAddressLine2;
		}

		public void setJobCompanyLocationAddressLine2(String jobCompanyLocationAddressLine2) {
			this.jobCompanyLocationAddressLine2 = jobCompanyLocationAddressLine2;
		}

		public String getJobCompanyLocationPostalCode() {
			return jobCompanyLocationPostalCode;
		}

		public void setJobCompanyLocationPostalCode(String jobCompanyLocationPostalCode) {
			this.jobCompanyLocationPostalCode = jobCompanyLocationPostalCode;
		}

		public String getJobCompanyLocationCountry() {
			return jobCompanyLocationCountry;
		}

		public void setJobCompanyLocationCountry(String jobCompanyLocationCountry) {
			this.jobCompanyLocationCountry = jobCompanyLocationCountry;
		}

		public String getJobCompanyLocationContinent() {
			return jobCompanyLocationContinent;
		}

		public void setJobCompanyLocationContinent(String jobCompanyLocationContinent) {
			this.jobCompanyLocationContinent = jobCompanyLocationContinent;
		}

		public String getJobLastUpdated() {
			return jobLastUpdated;
		}

		public void setJobLastUpdated(String jobLastUpdated) {
			this.jobLastUpdated = jobLastUpdated;
		}

		public String getJobStartDate() {
			return jobStartDate;
		}

		public void setJobStartDate(String jobStartDate) {
			this.jobStartDate = jobStartDate;
		}

		public String getJobSummary() {
			return jobSummary;
		}

		public void setJobSummary(String jobSummary) {
			this.jobSummary = jobSummary;
		}

		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}

		public String getLocationLocality() {
			return locationLocality;
		}

		public void setLocationLocality(String locationLocality) {
			this.locationLocality = locationLocality;
		}

		public String getLocationRegion() {
			return locationRegion;
		}

		public void setLocationRegion(String locationRegion) {
			this.locationRegion = locationRegion;
		}

		public String getLocationCountry() {
			return locationCountry;
		}

		public void setLocationCountry(String locationCountry) {
			this.locationCountry = locationCountry;
		}

		public String getLocationContinent() {
			return locationContinent;
		}

		public void setLocationContinent(String locationContinent) {
			this.locationContinent = locationContinent;
		}

		public String getLocationStreetAddress() {
			return locationStreetAddress;
		}

		public void setLocationStreetAddress(String locationStreetAddress) {
			this.locationStreetAddress = locationStreetAddress;
		}

		public String getLocationAddressLine2() {
			return locationAddressLine2;
		}

		public void setLocationAddressLine2(String locationAddressLine2) {
			this.locationAddressLine2 = locationAddressLine2;
		}

		public String getLocationPostalCode() {
			return locationPostalCode;
		}

		public void setLocationPostalCode(String locationPostalCode) {
			this.locationPostalCode = locationPostalCode;
		}

		public String getLocationGeo() {
			return locationGeo;
		}

		public void setLocationGeo(String locationGeo) {
			this.locationGeo = locationGeo;
		}

		public String getLocationLastUpdated() {
			return locationLastUpdated;
		}

		public void setLocationLastUpdated(String locationLastUpdated) {
			this.locationLastUpdated = locationLastUpdated;
		}

		public String getInferredSalary() {
			return inferredSalary;
		}

		public void setInferredSalary(String inferredSalary) {
			this.inferredSalary = inferredSalary;
		}

		public Integer getInferredYearsExperience() {
			return inferredYearsExperience;
		}

		public void setInferredYearsExperience(Integer inferredYearsExperience) {
			this.inferredYearsExperience = inferredYearsExperience;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}		

		
		public Long getId() {
			// TODO Auto-generated method stub
			return id;
		}
}
