/**
 * 
 */
package com.github.searchbroker.rest.jersey;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Vichai Vun
 *
 */
@Component("jerseySearchBroker")
public class DefaultJerseySearchBroker implements JerseySearchBroker {

	/**
	 * Default Constructor
	 */
	public DefaultJerseySearchBroker() {
		super();
	}

	@Override
	public ClientResponse search(final String url, final String keywords, final String sort, final String order, final String pageId,
			final String pageSize) {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

//			if (response.getStatus() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatus());
//			}
//
//			String output = response.getEntity(String.class);
//
//			System.out.println("Output from Server .... \n");
//			System.out.println(output);
			return response;
	}

}
