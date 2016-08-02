/**
 * 
 */
package com.github.searchbroker.rest;

/**
 * @author Vichai Vun
 *
 */
public interface SearchBroker {
	
	Object search(String apiUrl, String keyword, String sort, String order, String pageId, String pageSize);
}
