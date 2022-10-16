package com.michiko.lendingengine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.google.gson.Gson;
import com.michiko.lendingengine.application.model.LoanRequest;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class LoanIntegrationTesting {

	private static final String JOHN = "JOHN";
	private static final Gson GSON = new Gson();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;
	
	@Test
	public void givenLoanRequestIsMadeLoanApplicationGetsCreated() throws Exception {
		final String baseUrl = "http://localhost:" + serverPort + "/loan";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.AUTHORIZATION, JOHN);
		
		//HttpEntity<LoanRequest> request = new HttpEntity<>();
	}
}
