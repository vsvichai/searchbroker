/**
 * 
 */
package com.github.searchbroker.rest.gson;

import org.springframework.stereotype.Component;

/**
 * @author Vichai Vun
 *
 */
@Component("gsonSearchBroker")
public class DefaultGsonSearchBroker implements GsonSearchBroker {

	/**
	 * Default constructor
	 */
	public DefaultGsonSearchBroker() {
		super();
	}

	@Override
	public Object search(final String url, final String keywords, final String sort, final String order, final String pageId,
			final String pageSize) {
		return null;
	}

}
