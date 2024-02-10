package com.upstream_mobility_itacademy.bored.boredApiClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@TestInstance(Lifecycle.PER_CLASS)
public class BoredApiClientITests {

  private BoredApiClient boredApiClient;

  private MockWebServer mockBackEnd;

  @BeforeAll
  void setUp() throws IOException {
    mockBackEnd = new MockWebServer();
    mockBackEnd.start();
  }

  @BeforeEach
  void initialize() {
    String baseUrl = String.format(
      "http://localhost:%s",
      mockBackEnd.getPort()
    );

    boredApiClient = new BoredApiClient(WebClient.create(), baseUrl);
  }

  @AfterAll
  void tearDown() throws IOException {
    mockBackEnd.shutdown();
  }

  @Test
  public void testGetActivity() throws Exception {
    String activityJSON =
      "{\"activity\":\"Test Activity\",\"type\":\"education\",\"participants\":1,\"price\":0.5,\"link\":\"www.test.com\",\"key\":100}";

    mockBackEnd.enqueue(
      new MockResponse()
        .setResponseCode(200)
        .setBody(activityJSON)
        .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    );

    String activityFromApi = boredApiClient.getActivity(
      new ActivitySearchParams(
        "education",
        "1",
        "0.0",
        "0.5",
        "www.test.com",
        "100"
      )
    );
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    assertEquals(
      HttpMethod.GET.toString(),
      recordedRequest.getMethod(),
      "Client uses unexpected HTTP method"
    );
    assertEquals(
      "/?type=education&participants=1&price=0.0&accessibility=0.5&link=www.test.com&key=100",
      recordedRequest.getPath(),
      "Client requested wrong path"
    );
    assertEquals(
      "Test Activity",
      activityFromApi,
      "Client returned unexpected activity"
    );
  }

  @Test
  public void testNotFoundActivity() {
    String errorJSON =
      "{\"error\":\"No activity found with the specified parameters\"}";
    mockBackEnd.enqueue(
      new MockResponse()
        .setResponseCode(200)
        .setBody(errorJSON)
        .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    );

    String activityFromApi = boredApiClient.getActivity(
      new ActivitySearchParams(
        "education",
        "1",
        "0.0",
        "0.5",
        "www.test.com",
        "100"
      )
    );

    assertEquals(
      "No activities with searched parameters were found:(",
      activityFromApi,
      "Client returned unexpected activity"
    );
  }
}
