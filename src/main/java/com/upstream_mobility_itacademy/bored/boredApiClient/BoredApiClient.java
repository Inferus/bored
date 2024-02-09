package com.upstream_mobility_itacademy.bored.boredApiClient;

import com.upstream_mobility_itacademy.bored.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BoredApiClient {

  private final WebClient webClient;

  private final String baseUrl;

  public BoredApiClient(WebClient webClient, String baseUrl) {
    this.webClient = webClient;
    this.baseUrl = baseUrl;
  }

  @Autowired
  public BoredApiClient(WebClient webClient) {
    this.webClient = webClient;
    this.baseUrl = "https://www.boredapi.com/api/activity";
  }

  public String getActivity(ActivitySearchParams activitySearchParams) {
    String type = activitySearchParams.getType();
    String participants = activitySearchParams.getParticipants();
    String price = activitySearchParams.getPrice();
    String accessibility = activitySearchParams.getAccessibility();
    String link = activitySearchParams.getLink();
    String key = activitySearchParams.getKey();

    Activity activity = webClient
      .get()
      .uri(
        baseUrl,
        uriBuilder ->
          uriBuilder
            .queryParam("type", type)
            .queryParam("participants", participants)
            .queryParam("price", price)
            .queryParam("accessibility", accessibility)
            .queryParam("link", link)
            .queryParam("key", key)
            .build()
      )
      .retrieve()
      .bodyToMono(Activity.class)
      .block();

    if (activity.getActivity() == null) {
      return "No activities with searched parameters were found:(";
    }

    return activity.getActivity();
  }
}
