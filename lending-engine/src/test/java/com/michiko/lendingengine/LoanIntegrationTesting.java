package com.michiko.lendingengine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.michiko.lendingengine.application.model.LoanApplicationDTO;
import com.michiko.lendingengine.application.model.LoanRequest;
import com.rabbitmq.client.RpcClient.Response;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles(profiles = "test")
public class LoanIntegrationTesting {

	private static final String JOHN = "John";
	private static final Gson GSON = new Gson();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;
	
	@Test
	public void givenLoanRequestIsMadeLoanApplicationGetsCreated() throws Exception {
		final String baseUrl = "http://localhost:" + serverPort + "/loan";
		HttpHeaders httpHeaders = getHttpHeaders();
		
		HttpEntity<LoanRequest> request = new HttpEntity<>(new LoanRequest(50, 10, 10), httpHeaders);
		
		restTemplate.postForEntity(baseUrl + "/request", request, String.class);
		
		ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/requests", HttpMethod.GET, 
						new HttpEntity(null, getHttpHeaders()), String.class);
		
		List<LoanApplicationDTO> loanApplicationDTOs = GSON
				.fromJson(response.getBody(), new TypeToken<List<LoanApplicationDTO>>(){}.getType());
		
		assertEquals(1, loanApplicationDTOs.size());
		assertEquals(loanApplicationDTOs.get(0).getBorrower().getUsername(), JOHN);

	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.AUTHORIZATION, JOHN);
		return httpHeaders;
	}
}
