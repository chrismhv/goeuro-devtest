package com.km.goeuro.devtest.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonPropertyOrder(value = { "_id", "name", "type", "geo_position" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionDomain 
{
	@JsonProperty(value = "_id")
	public String _id;
	
	@JsonProperty(value = "name")
	public String name;
	
	@JsonProperty(value = "type")
	public String type;
	
	@JsonProperty(value = "geo_position")
	@JsonUnwrapped
	public GeoPositionDomain geoPosition;

	public PositionDomain()
	{
	}
	
	public PositionDomain(String _id, String name, String type, GeoPositionDomain geoPosition) {
		super();
		this._id = _id;
		this.name = name;
		this.type = type;
		this.geoPosition = geoPosition;
	}

	@Override
	public String toString() {
		return "PositionDomain [_id=" + _id + ", name=" + name + ", type=" + type + ", geoPosition=" + geoPosition
				+ "]";
	}
	
}
