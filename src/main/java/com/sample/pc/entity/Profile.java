package com.sample.pc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "network",
    "id",
    "url",
    "username"
})

@Entity
public class Profile implements Serializable{

	private static final long serialVersionUID = 7331105798122343885L;
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long sno;
	
	@JsonProperty("network")
    private String network; 
	@JsonProperty("id")
    private String id;  
	@JsonProperty("url")
    private String url; 
	@JsonProperty("username")
    private String username;
    
    public Profile() {}

	public Long getSno() {
		return sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}	

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
