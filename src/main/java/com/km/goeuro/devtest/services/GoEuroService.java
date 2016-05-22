package com.km.goeuro.devtest.services;

import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.km.goeuro.devtest.domain.PositionDomain;
import com.km.goeuro.devtest.filters.ErrorResponseFilter;
import com.km.goeuro.devtest.resources.GoEuroResource;

public class GoEuroService 
{
	private final Logger logger = LoggerFactory.getLogger(GoEuroService.class);
	private static final String GO_EURO_ENDPOINT = "http://api.goeuro.com/api";
	private static final GoEuroService INSTANCE = new GoEuroService();
	
	private GoEuroResource resource;
	
	private GoEuroService()
	{
		resource = new ResteasyClientBuilder()
				.register(JacksonJsonProvider.class)
				.register(ErrorResponseFilter.class)
				.build().target(GO_EURO_ENDPOINT)
				.proxy(GoEuroResource.class);
	}
	
	public static GoEuroService getInstance()
	{
		return INSTANCE;
	}
	
	public PositionDomain[] getPositionSuggestions(String cityName)
	{
		Response response = null;
		try {
			response = resource.getPositionSuggestions(cityName);
		}
		catch(ResponseProcessingException ex)
		{
			System.err.println(ex.getCause().getLocalizedMessage());
			logger.error(ex.getCause().getLocalizedMessage());
			return null;
		}
		
		try {
				return response.readEntity(PositionDomain[].class);
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			response.close();
		}
		
		return null;
	}
}
