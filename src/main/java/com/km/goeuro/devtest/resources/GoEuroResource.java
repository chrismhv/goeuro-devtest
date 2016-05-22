package com.km.goeuro.devtest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public interface GoEuroResource 
{
	@GET
	@Path("/v2/position/suggest/en/{city_name}")
	@Produces(MediaType.APPLICATION_JSON)
	Response getPositionSuggestions(@PathParam(value = "city_name") String cityName);
}
