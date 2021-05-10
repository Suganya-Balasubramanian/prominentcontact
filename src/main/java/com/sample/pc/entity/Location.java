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
    "name",
    "locality",
    "region",
    "country",
    "continent",
    "street_address",
    "address_line_2",
    "postal_code",
    "geo"
})


@Entity
public class Location implements Serializable{
	
	private static final long serialVersionUID = -2279950982541049404L;
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY	 )
    private Long sno;
	
	@JsonProperty("name")
    private String name;
	@JsonProperty("locality")
    private String locality; 
	@JsonProperty("region")
    private String region;
	@JsonProperty("country")
    private String country;
	@JsonProperty("continent")
    private String continent;
	@JsonProperty("street_address")
    private String streetAddress;
	@JsonProperty("address_line_2")
    private String addressLine2;
	@JsonProperty("postal_code")
    private String postalCode;
	@JsonProperty("geo")
    private String geo;
  
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

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	
}
