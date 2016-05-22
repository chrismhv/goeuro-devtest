package com.km.goeuro.devtest.filters;

import java.io.IOException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import com.km.goeuro.devtest.error.ErrorResponse;

@Provider
public class ErrorResponseFilter implements ClientResponseFilter
{
	private static ObjectMapper _MAPPER = new ObjectMapper();
	
	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext)
			throws IOException
	{
		if (responseContext.getStatus() != Response.Status.OK.getStatusCode())
		{
			if(responseContext.hasEntity())
			{
				ErrorResponse error = _MAPPER.readValue(responseContext.getEntityStream(), ErrorResponse.class);
        String message = String.format("%s: %s", error.getMessage(), error.getDescription());
        
        Response.Status status = Response.Status.fromStatusCode(responseContext.getStatus());
        WebApplicationException webAppException;
        switch (status) {
        case BAD_REQUEST:
            webAppException = new BadRequestException(message);
            break;
        case NOT_FOUND:
        	webAppException = new NotFoundException(message);
        	break;
        default:
          webAppException = new WebApplicationException(message);
        }
        throw webAppException;
			}
		}
	}
}
