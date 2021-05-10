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
    "name",
    "role",
    "sub_role",
    "levels"
})

@Entity
public class Title implements Serializable{

	private static final long serialVersionUID = 1463611047701795236L;
		@Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY )
	    private Long sno;
		
		@JsonProperty("name")
	    private String name;
		
		@JsonProperty("role")
	    private String role;
		
		@JsonProperty("sub_role")
	    private String subRole;	
	    
		@JsonProperty("levels")		
		@ElementCollection
	    private List<String> levels = null;

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

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getSubRole() {
			return subRole;
		}

		public void setSubRole(String subRole) {
			this.subRole = subRole;
		}

		public List<String> getLevels() {
			return levels;
		}

		public void setLevels(List<String> levels) {
			this.levels = levels;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
