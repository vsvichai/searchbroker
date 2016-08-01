/**
 * 
 */
package com.github.searchbroker.rest;

/**
 * @author Vichai Vun
 *
 */
public interface SearchBroker {
	
	Object search(String url, String keywords, String sort, String order, String pageId, String pageSize);

}
