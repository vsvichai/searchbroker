/**
 * 
 */
package com.github.searchbroker.rest.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.searchbroker.rest.jersey.JerseySearchBroker;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author Vichai Vun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-test-context.xml"})
public class SearchBrokerTest {
	
	@Resource(name = "jerseySearchBroker")
	private JerseySearchBroker _jerseySearchBroker;
	
	@Test
	public void testSearchWithJersey() throws Exception {
		ClientResponse clientResponse = (ClientResponse) _jerseySearchBroker.search("https://api.github.com/search/repositories", "liferay", "", "", "", "");
		String output = clientResponse.getEntity(String.class);
		System.out.println(output);
	}
}
