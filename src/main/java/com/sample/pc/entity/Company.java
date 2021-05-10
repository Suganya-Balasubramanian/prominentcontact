package com.sample.pc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "size",
    "id",
    "founded",
    "industry",
    "location",
    "linkedin_url",
    "linkedin_id",
    "facebook_url",
    "twitter_url",
    "website"
})

@Entity
public class Company implements Serializable{
			
		private static final long serialVersionUID = -6706958454263802555L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY )
	    private Long sno;
		
		@JsonProperty("name")
	    private String name;		
		@JsonProperty("size")
	    private String size;
		@JsonProperty("id")
	    private String id;		
		@JsonProperty("founded")
	    private String founded;		
		@JsonProperty("industry")
	    private String industry;
		
		@JsonProperty("location")
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinTable(name="company_location", joinColumns = @JoinColumn(name="company_sno"),
	    inverseJoinColumns = @JoinColumn(name="location_sno"))
	    private Location location;
		
		@JsonProperty("linkedin_url")
	    private String linkedinUrl;
		@JsonProperty("linkedin_id")
	    private String linkedinId;
		@JsonProperty("facebook_url")
	    private String facebookUrl;
		@JsonProperty("twitter_url")
	    private String twitterUrl;
		@JsonProperty("website")
	    private String website;
		public Long getSno() {
			return sno;
		}
		public void setSno(Long sno) {
			this.sno = sno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFounded() {
			return founded;
		}
		public void setFounded(String founded) {
			this.founded = founded;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public String getLinkedinUrl() {
			return linkedinUrl;
		}
		public void setLinkedinUrl(String linkedinUrl) {
			this.linkedinUrl = linkedinUrl;
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
		public String getTwitterUrl() {
			return twitterUrl;
		}
		public void setTwitterUrl(String twitterUrl) {
			this.twitterUrl = twitterUrl;
		}
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}	    
		
}
