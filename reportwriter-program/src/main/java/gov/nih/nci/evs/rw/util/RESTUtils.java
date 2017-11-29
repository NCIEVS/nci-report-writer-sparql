package gov.nih.nci.evs.rw.util;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * Helper class using the RestTemplate to call the SPARQL endpoint using a SPARQL query.
 *
 */
public class RESTUtils {

	private static final Logger log = LoggerFactory.getLogger(RESTUtils.class);private String restURL;

	private String username;
	private String password;
	private int readTimeout;
	private int connectTimeout;

	public RESTUtils () {}

	public RESTUtils(String restURL,String username, String password,int readTimeout, int connectTimeout) {
		this.restURL = restURL;
		this.username = username;
		this.password = password;
		this.readTimeout= readTimeout;
		this.connectTimeout = connectTimeout;
	}

	/**
	 * 
	 * Post a SPARQL query to the SPARQL endpoint and return the results.
	 * 
	 * @param query SPARQL query.
	 * @return SPARQL results.
	 */
	public String runSPARQL(String query) {
		RestTemplate restTemplate = new RestTemplateBuilder().
				rootUri(restURL).
				basicAuthorization(username,password).
				setReadTimeout(readTimeout).
				setConnectTimeout(connectTimeout).
				build();
		restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(Charset.forName("UTF-8")));
		MultiValueMap <String,String> body = new LinkedMultiValueMap<String,String>();
		body.add("query", query);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Arrays.asList(new MediaType("application","sparql-results+json")));
		HttpEntity<?> entity = new HttpEntity<Object>(body ,headers);
		String results = restTemplate.postForObject(restURL,entity,String.class);
		return results;
	}
}