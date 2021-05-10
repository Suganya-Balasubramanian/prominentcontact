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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "company",
    "start_date",
    "end_date",
    "title",
    "location_names",
    "is_primary",
    "summary"
})

@Entity
public class Experience implements Serializable{
		
		private static final long serialVersionUID = -5953172244886044685L;
		@Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY )
	    private Long sno;
		
		@JsonProperty("company")		
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinTable(name="experience_company", joinColumns = @JoinColumn(name="experience_sno"),
	    inverseJoinColumns = @JoinColumn(name="company_sno"))
	    private Company company;
		
		@JsonProperty("start_date")
	    private String startDate;
		
		@JsonProperty("end_date")
	    private String endDate;
		
		@JsonProperty("title")	    
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinTable(name="experience_title", joinColumns = @JoinColumn(name="experience_sno"),
	    inverseJoinColumns = @JoinColumn(name="title_sno"))
	    private Title title;
		
		@JsonProperty("location_names")	
		@ElementCollection
	    private List<String> locationNames = null;

		@JsonProperty("is_primary")
	    private Boolean isPrimary;
		
	    @JsonProperty("summary")
	    private String summary;

		public Long getSno() {
			return sno;
		}

		public void setSno(Long sno) {
			this.sno = sno;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public Title getTitle() {
			return title;
		}

		public void setTitle(Title title) {
			this.title = title;
		}

		public List<String> getLocationNames() {
			return locationNames;
		}

		public void setLocationNames(List<String> locationNames) {
			this.locationNames = locationNames;
		}

		public Boolean getIsPrimary() {
			return isPrimary;
		}

		public void setIsPrimary(Boolean isPrimary) {
			this.isPrimary = isPrimary;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
