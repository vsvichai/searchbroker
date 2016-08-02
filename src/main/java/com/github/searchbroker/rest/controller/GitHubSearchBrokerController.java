/**
 * 
 */
package com.github.searchbroker.rest.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.github.searchbroker.rest.jersey.JerseySearchBroker;

/**
 * @author Vichai Vun
 *
 */
@Controller
public class GitHubSearchBrokerController {
	
	private static final String GIT_HUB_REPOSITORY_SEARCH_API = "https://api.github.com/search/repositories";
	
	@Resource(name = "jerseySearchBroker")
	private JerseySearchBroker _jerseySearchBroker;

	/**
	 *Default constructor
	 */
	public GitHubSearchBrokerController() {
		super();
	}
	
	

}
