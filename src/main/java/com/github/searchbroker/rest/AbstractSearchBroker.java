/**
 * 
 */
package com.github.searchbroker.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author Vichai Vun
 *
 */
public abstract class AbstractSearchBroker implements SearchBroker {
	
	protected static final int CONNECTION_TIMEOUT = 1000; //The interval is in milliseconds
	protected static final int READ_TIMEOUT = 30000; //The interval is in milliseconds
	
	private static final String REQUEST_PARAMETER_CONJUNCTION = "&";
	private static final String REQUEST_PARAMETER_VALUE_CONJUNCTION = "=";
	
	/* Request's parameters */
	private static final String SEARCH_KEYWORD_REQUEST_PARAMETER = "q";
	private static final String SORT_REQUEST_PARAMETER = "sort";
	private static final String SORT_ORDER_REQUEST_PARAMETER = "order";
	private static final String PAGE_NUMBER_REQUEST_PARAMETER = "page";
	private static final String PAGE_SIZE_REQUEST_PARAMETER = "per_page";
	
	/* Values for request's sort parameter */
	private static final String STARS_SORT_PARAMETER = "stars";
	private static final String FORKS_SORT_PARAMETER = "forks";
	private static final String UPDATED_SORT_PARAMETER = "updated";
	private static final String DEFAULT_SORT_PARAMETER = "default";
	protected static final Map<String, String> SORT_REQUEST_PARAMETERS = new HashMap<String, String>();
	static {
		SORT_REQUEST_PARAMETERS.put(STARS_SORT_PARAMETER, STARS_SORT_PARAMETER);
		SORT_REQUEST_PARAMETERS.put(FORKS_SORT_PARAMETER, FORKS_SORT_PARAMETER);
		SORT_REQUEST_PARAMETERS.put(UPDATED_SORT_PARAMETER, UPDATED_SORT_PARAMETER);
		SORT_REQUEST_PARAMETERS.put(DEFAULT_SORT_PARAMETER, STARS_SORT_PARAMETER);
	}
	/* Values for request's sort order */
	private static final String ASCENDING_SORT_ORDER_PARAMETER = "asc";
	private static final String DESCENDING_SORT_ORDER_PARAMETER = "desc";
	private static final String DEFAULT_SORT_ORDER_PARAMETER = "default";
	protected static final Map<String, String> SORT_ORDER_REQUEST_PARAMETERS = new HashMap<String, String>();
	static {
		SORT_ORDER_REQUEST_PARAMETERS.put(ASCENDING_SORT_ORDER_PARAMETER, ASCENDING_SORT_ORDER_PARAMETER);
		SORT_ORDER_REQUEST_PARAMETERS.put(DESCENDING_SORT_ORDER_PARAMETER, DESCENDING_SORT_ORDER_PARAMETER);
		SORT_ORDER_REQUEST_PARAMETERS.put(DEFAULT_SORT_ORDER_PARAMETER, DESCENDING_SORT_ORDER_PARAMETER);
	}

	/**
	 * Default constructor
	 */
	public AbstractSearchBroker() {
		super();
	}
	
	
	protected String buildRequestUrl(final String apiUrl, final String keyword, final String sort, final String order, final String pageId,
			final String pageSize) {
		StringBuilder urlBuilder = new StringBuilder(apiUrl);
		urlBuilder.append("?");
		urlBuilder.append(SEARCH_KEYWORD_REQUEST_PARAMETER);
		urlBuilder.append(REQUEST_PARAMETER_VALUE_CONJUNCTION);
		urlBuilder.append(keyword);
		if(StringUtils.isNotBlank(sort)) {
			urlBuilder.append(REQUEST_PARAMETER_CONJUNCTION);
			urlBuilder.append(SORT_REQUEST_PARAMETER);
			urlBuilder.append(REQUEST_PARAMETER_VALUE_CONJUNCTION);
			if(SORT_REQUEST_PARAMETERS.get(sort) != null) {
				urlBuilder.append(SORT_REQUEST_PARAMETERS.get(sort.toLowerCase()));
			}
			else {
				urlBuilder.append(SORT_REQUEST_PARAMETERS.get(DEFAULT_SORT_PARAMETER));
			}
			urlBuilder.append(REQUEST_PARAMETER_CONJUNCTION);
			urlBuilder.append(SORT_ORDER_REQUEST_PARAMETER);
			urlBuilder.append(REQUEST_PARAMETER_VALUE_CONJUNCTION);
			if(SORT_ORDER_REQUEST_PARAMETERS.get(order) != null) {
				urlBuilder.append(SORT_ORDER_REQUEST_PARAMETERS.get(order.toLowerCase()));
			}
			else {
				urlBuilder.append(SORT_ORDER_REQUEST_PARAMETERS.get(DEFAULT_SORT_ORDER_PARAMETER));
			}
		}
		boolean isValidPageId = StringUtils.isNotBlank(pageId) && StringUtils.isNumeric(pageId) && pageId != "0";
		boolean isValidPageSize = StringUtils.isNotBlank(pageSize) && StringUtils.isNumeric(pageSize) && pageSize != "0";
		if(isValidPageId && isValidPageSize) {
			urlBuilder.append(REQUEST_PARAMETER_CONJUNCTION);
			urlBuilder.append(PAGE_NUMBER_REQUEST_PARAMETER);
			urlBuilder.append(REQUEST_PARAMETER_VALUE_CONJUNCTION);
			urlBuilder.append(pageId);
			urlBuilder.append(REQUEST_PARAMETER_CONJUNCTION);
			urlBuilder.append(PAGE_SIZE_REQUEST_PARAMETER);
			urlBuilder.append(REQUEST_PARAMETER_VALUE_CONJUNCTION);
			urlBuilder.append(pageSize);
		}
		return urlBuilder.toString();
	}

}
