/**
 * 
 */
package com.github.searchbroker.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.searchbroker.rest.jersey.JerseySearchBroker;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author Vichai Vun
 *
 */
@Path(value = "/")
@Component
public class GitHubSearchBroker {
	
	private static final String GIT_HUB_REPOSITORY_SEARCH_API = "https://api.github.com/search/repositories";
	
	@Autowired
	private JerseySearchBroker _jerseySearchBroker;

	/**
	 *Default constructor
	 */
	public GitHubSearchBroker() {
		super();
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
    public Response searchWithJersey(@QueryParam(value = "q") final String keyword, @QueryParam(value = "sort") final String sort, @QueryParam(value = "order") final String order, @QueryParam(value = "page") final String pageId, @QueryParam(value = "per_page") final String pageSize, @QueryParam(value = "connection_time_out") final int connectionTimeOut, @QueryParam(value = "request_time_out") final int requestTimeOut)   {
		if(StringUtils.isBlank(keyword)) {
			throw new IllegalArgumentException("The keyword 'q' must not be null or empty.");
		}
		try {
			ClientResponse clientResponse = (ClientResponse) _jerseySearchBroker.search(GIT_HUB_REPOSITORY_SEARCH_API, keyword, sort, order, pageId, pageSize, connectionTimeOut, requestTimeOut);
			String result = clientResponse.getEntity(String.class);
			return Response.status(200).entity(result).build(); 
		}
		catch (ClientHandlerException e) {
			if(e.getCause().getMessage().equalsIgnoreCase("connect timed out")) {
				return Response.status(504 ).entity("The service reached the limit connection time out! Please check your Internet connection or consider increasing the limit connection time out. The default value for connection_time_out is 1000 milliseconds.").build();
			}
			else if(e.getCause().getMessage().equalsIgnoreCase("read timed out")) {
				return Response.status(408).entity("The service reached the limit request time out! Please consider either increasing the limit request time out or setting the page and per_page properties. Maximum data to return is 1000, so please set the page and per_page properties accordingly. The default value for request_time_out 30000 milliseconds.").build();
			}
			else {
				return Response.status(503).entity("Service not available.").build();
			}
		}
    }

}
