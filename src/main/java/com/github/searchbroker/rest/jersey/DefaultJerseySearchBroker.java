/**
 * 
 */
package com.github.searchbroker.rest.jersey;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.github.searchbroker.rest.AbstractSearchBroker;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;

/**
 * @author Vichai Vun
 *
 */
@Component("jerseySearchBroker")
public class DefaultJerseySearchBroker extends AbstractSearchBroker implements JerseySearchBroker {

	/**
	 * Default Constructor
	 */
	public DefaultJerseySearchBroker() {
		super();
	}

	public ClientResponse search(final String apiUrl, final String keyword, final String sort, final String order, final String pageId,
			final String pageSize) throws ClientHandlerException {
		
		Client client = Client.create();
		client.setConnectTimeout(CONNECTION_TIMEOUT);
		client.setReadTimeout(READ_TIMEOUT);
		String requestUrl = buildRequestUrl(apiUrl, keyword, sort, order, pageId, pageSize);
		WebResource webResource = client.resource(requestUrl);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		return response;
	}
}
