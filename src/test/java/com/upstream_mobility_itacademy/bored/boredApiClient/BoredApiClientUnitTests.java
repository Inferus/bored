package com.upstream_mobility_itacademy.bored.boredApiClient;


import static org.junit.Assert.assertSame;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;


public class BoredApiClientUnitTests {

private BoredApiClient boredApiClient;



 public static MockWebServer mockBackEnd;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @BeforeEach
void initialize() {
    String baseUrl = String.format("http://localhost:%s", 
      mockBackEnd.getPort());

    boredApiClient = new BoredApiClient(WebClient.create(),baseUrl);
}

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }
@Test
public void testGetActivityById() throws Exception {
    mockBackEnd.enqueue(new MockResponse()
    .setResponseCode(200)
      .setBody("{\"activity\":\"Test Activity\",\"type\":\"education\",\"participants\":1,\"price\":0.5,\"link\":\"www.test.com\",\"key\":100}")
      .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
    
        boredApiClient.getActivity(new ActivitySearchParams("education", "1", "0.0", "0.5", "www.test.com", "100"));
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    assertEquals("GET", recordedRequest.getMethod(), "Client uses unexpected HTTP method");
    assertEquals("/?type=education&participants=1&price=0.0&accessibility=0.5&link=www.test.com&key=100", recordedRequest.getPath() , "Client requested wrong path");


}   

}