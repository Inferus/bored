package com.upstream_mobility_itacademy.bored.service;

import com.upstream_mobility_itacademy.bored.validator.InputValidator;

public class ActivityService {

  @Autowired
  private BoredApiClient boredClient;

  public String getActivity(ActivitySearchParams activitySearchParams) {
    try {
      InputValidator.validateSearchParams(activitySearchParams);
    } catch (NumberFormatException e) {
      return "Invalid input: " + e.getMessage();
    } catch (Exception e) {
      return e.getMessage();
    }

    return boredClient.getActivity(activitySearchParams);
  }
}
