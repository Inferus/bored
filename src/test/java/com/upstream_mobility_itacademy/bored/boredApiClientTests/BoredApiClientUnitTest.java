package com.upstream_mobility_itacademy.bored.boredApiClientTests;

import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

import com.upstream_mobility_itacademy.bored.boredApiClient.BoredApiClient;

public class BoredApiClientUnitTest {

    @MockBean
    private WebClient mockWebClient;


    private BoredApiClient underTest;





    @Test
   public void testGetActivity(){
    
    }


    // Activity mockActivity = new Activity("Learn Express.js", 0.25f, "education", 1, 0.1f, "https://expressjs.com/", "3943506");



}