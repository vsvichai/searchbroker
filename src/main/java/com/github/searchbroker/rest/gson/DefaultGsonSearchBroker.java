/**
 * 
 */
package com.github.searchbroker.rest.gson;

import org.springframework.stereotype.Component;

import com.github.searchbroker.rest.AbstractSearchBroker;

/**
 * @author Vichai Vun
 *
 */
@Component("gsonSearchBroker")
public class DefaultGsonSearchBroker extends AbstractSearchBroker implements GsonSearchBroker {

	/**
	 * Default constructor
	 */
	public DefaultGsonSearchBroker() {
		super();
	}

	public Object search(final String url, final String keywords, final String sort, final String order, final String pageId,
			final String pageSize, final int connectionTimeOut, final int requestTimeOut) {
//		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
//            HttpPost request = new HttpPost(url);
//            StringEntity params = new StringEntity(body);
//            request.addHeader("content-type", "application/json");
//            request.setEntity(params);
//            HttpResponse result = httpClient.execute(request);
//            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
//
//            com.google.gson.Gson gson = new com.google.gson.Gson();
//            Response respuesta = gson.fromJson(json, Response.class);
//
//            System.out.println(respuesta.getExample());
//            System.out.println(respuesta.getFr());
//
//        } catch (IOException ex) {
//        }
		return null;
	}

}
