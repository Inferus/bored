package com.upstream_mobility_itacademy.bored.boredApiClientTests;

import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;
import com.upstream_mobility_itacademy.bored.boredApiClient.BoredApiClient;
import com.upstream_mobility_itacademy.bored.model.Activity;

public class BoredApiClientUnitTest {

    @MockBean
    private WebClient mockWebClient;

    private MockWebServer mockWebServer;
    private BoredApiClient underTest;





    @Test
   public void testGetActivity(){
    ActivitySearchParams activitySearchParams = new ActivitySearchParams("education", "1", "0.1", "https://expressjs.com/", "3943506");
    underTest.getActivity();
    }


    // Activity mockActivity = new Activity("Learn Express.js", 0.25f, "education", 1, 0.1f, "https://expressjs.com/", "3943506");



}