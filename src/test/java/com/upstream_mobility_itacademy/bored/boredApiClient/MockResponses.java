package com.upstream_mobility_itacademy.bored.boredApiClient;

public enum MockResponses {
  NO_ACTIVITY_FOUND_WITH_PARAMS(
    "{\"error\":\"No activity found with the specified parameters\"}"
  ),
  ACTIVITY_RESPONSE(
    "{\"activity\":\"Test Activity\",\"type\":\"education\",\"participants\":1,\"price\":0.5,\"link\":\"www.test.com\",\"key\":100}"
  );

  private final String response;

  MockResponses(String response) {
    this.response = response;
  }

  @Override
  public String toString() {
    return response;
  }
}
