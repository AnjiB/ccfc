package com.anji.finance.ccfc;

import java.util.HashMap;
import java.util.Map;

import com.simple.api.core.contract.ApiResponse;
import com.simple.api.core.enums.RequestMethod;
import com.simple.api.core.impl.BaseApiClient;
import com.simple.api.core.modal.RestRequest;
import java.util.List;

import io.restassured.filter.Filter;
import io.restassured.http.ContentType;

public class FraudTestClient extends BaseApiClient {

	public FraudTestClient(String baseURL) {
		super(baseURL);
	}
	
	// Pass LocalDate instead of String
	public ApiResponse getFraudScoreForValidCreditCard(String creditCard, String expDate, Map<String, String> heads, List<Filter> filters) throws Exception {
		
		Map<String, String> queryMap = new HashMap<>();
		queryMap.put("cc", creditCard);
		queryMap.put("exp", expDate);
		
		
		RestRequest request = RestRequest.builder()
				.method(RequestMethod.GET)
				.contentType(ContentType.JSON)
				.headers(heads)
				.filters(filters)
				.path("/v1/fraudcheck/score")
				.queryParams(queryMap)
				.build();
		
		return send(request);
	}
}
