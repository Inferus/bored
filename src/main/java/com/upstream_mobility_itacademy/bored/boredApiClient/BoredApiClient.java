package com.upstream_mobility_itacademy.bored.boredApiClient;

import com.upstream_mobility_itacademy.bored.model.Activity;
import com.upstream_mobility_itacademy.bored.util.Generated;
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

  @Generated
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
    String key = activitySearchParams.getKey();
    String minprice = activitySearchParams.getMinprice();
    String maxprice = activitySearchParams.getMaxprice();
    String minaccessibility = activitySearchParams.getMinaccessibility();
    String maxaccessibility = activitySearchParams.getMaxaccessibility();

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
            .queryParam("key", key)
            .queryParam("minprice", minprice)
            .queryParam("maxprice", maxprice)
            .queryParam("minaccessibility", minaccessibility)
            .queryParam("maxaccessibility", maxaccessibility)
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
