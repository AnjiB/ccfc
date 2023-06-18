package com.anji.finance.ccfc;

import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.String.valueOf;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.anji.finance.ccfc.dto.CCFraudInfo;
import com.simple.api.core.contract.ApiResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CcfcProviderVerificationTest {
	
	private static final String VALID_CC = "4532788397355156";

	private static final String USER_CREDS = "Basic YW5qaWFkbWluOmFnb29kcWFwZXJzb24=";

	private static final String HOST  = "http://localhost:";
	
	@LocalServerPort
	private int port;
	
	@Test
	public void testFraudScoreForValidCreditCard() throws Exception {
	
		FraudTestClient ftc = new FraudTestClient(HOST + valueOf(port));
		ApiResponse response = ftc.getFraudScoreForValidCreditCard(VALID_CC, "2023-03-31", Map.of("Authorization", USER_CREDS));
		assertThat(response.getStatusCode()).isEqualTo(200);
		var body = response.getResponseBodyAs(CCFraudInfo.class);
		assertThat(body.getCcNumber()).isEqualTo(VALID_CC);
		assertThat(body.getIssueDate()).isEqualTo("2019-03-31");
		assertThat(body.getExpDate()).isEqualTo("2023-03-31");
		assertThat(body.getFraudProps().getIssuer()).isEqualTo("VISA");
		assertThat(body.getFraudProps().getFraudScore()).isEqualTo(700);
		
	}
	
	
	@Test
	public void testErroMessageForInvalidCreditCard() throws Exception {
		
		FraudTestClient ftc = new FraudTestClient(HOST + valueOf(port));
		ApiResponse response = ftc.getFraudScoreForValidCreditCard("test", "2023-03-31", Map.of("Authorization", USER_CREDS));
		assertThat(response.getStatusCode()).isEqualTo(500);
		var body = response.getResponseBodyAs(CCFraudInfo.class);
		assertThat(body.getError()).isEqualTo("There is no credit with given card number. Please enter valid credit card");
	}
	
	
	@Test
	public void testErroMessageForInvalidExpDate() throws Exception {
		
		FraudTestClient ftc = new FraudTestClient(HOST + valueOf(port));
		ApiResponse response = ftc.getFraudScoreForValidCreditCard(VALID_CC, "2023-03-31sfsf", Map.of("Authorization", USER_CREDS));
		assertThat(response.getStatusCode()).isEqualTo(400);
		var body = response.getResponseBodyAs(CCFraudInfo.class);
		assertThat(body.getError()).isEqualTo("Bad Request");
	}
	
	@Test
	public void testErroMessageForInvalidCreds() throws Exception {
		
		FraudTestClient ftc = new FraudTestClient(HOST + valueOf(port));
		ApiResponse response = ftc.getFraudScoreForValidCreditCard(VALID_CC, "2023-03-31", Map.of("Authorization", "Basic YW5qaWFkbWluZGQ6YWdvb2RxYXBlcnNvbg=="));
		assertThat(response.getStatusCode()).isEqualTo(401);
		var body = response.getResponseBodyAs(CCFraudInfo.class);
		assertThat(body.getError()).isEqualTo("Bad credentials");
	}
	
}
