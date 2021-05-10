package com.sample.pc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "contains",
    "previous_version",
    "current_version"
})

@Entity
public class VersionStatus implements Serializable{

	
	private static final long serialVersionUID = 8111941419688623262L;
		@Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY )
	    private Long sno;		
		
		@JsonProperty("status")
	    private String status;
		
		@JsonProperty("contains")	
		@ElementCollection
	    private List<String> contains = null;
		
		@JsonProperty("previous_version")
	    private String previousVersion;
		
		@JsonProperty("current_version")
	    private String currentVersion;

		public Long getSno() {
			return sno;
		}

		public void setSno(Long sno) {
			this.sno = sno;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<String> getContains() {
			return contains;
		}

		public void setContains(List<String> contains) {
			this.contains = contains;
		}

		public String getPreviousVersion() {
			return previousVersion;
		}

		public void setPreviousVersion(String previousVersion) {
			this.previousVersion = previousVersion;
		}

		public String getCurrentVersion() {
			return currentVersion;
		}

		public void setCurrentVersion(String currentVersion) {
			this.currentVersion = currentVersion;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
