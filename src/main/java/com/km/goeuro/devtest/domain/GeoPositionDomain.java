package com.km.goeuro.devtest.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "latitude", "longitude" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPositionDomain 
{
	@JsonProperty(value = "latitude")
	public String latitude;
	
	@JsonProperty(value = "longitude")
	public String longitude;

	public GeoPositionDomain()
	{
	}
	
	public GeoPositionDomain(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "GeoPositionDomain [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
