package com.upstream_mobility_itacademy.bored.validator;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;
import com.upstream_mobility_itacademy.bored.util.Generated;

public class InputValidator {

  @Generated
  public InputValidator() {}

  public static void validateSearchParams(
    ActivitySearchParams activitySearchParams
  ) throws Exception {
    String[] paramsList = activitySearchParams.getActivitySerachParamsList();

    for (String param : paramsList) {
      if (param == null) {
        throw new Exception("Empty parameter found");
      }
    }

    if (!activitySearchParams.getParticipants().equals("")) {
      try {
        Integer.parseInt(activitySearchParams.getParticipants());
      } catch (NumberFormatException e) {
        throw new NumberFormatException(
          "Participants parameter is not a number"
        );
      }
    }

    if (!activitySearchParams.getPrice().equals("")) {
      try {
        Float.parseFloat(activitySearchParams.getPrice());
      } catch (NumberFormatException e) {
        throw new NumberFormatException("Price parameter is not a number");
      }
    }
    if (!activitySearchParams.getAccessibility().equals("")) {
      try {
        Float.parseFloat(activitySearchParams.getAccessibility());
      } catch (NumberFormatException e) {
        throw new NumberFormatException(
          "Accessibility parameter is not a number"
        );
      }
    }

    if (!activitySearchParams.getKey().equals("")) {
      try {
        Integer.parseInt(activitySearchParams.getKey());
      } catch (NumberFormatException e) {
        throw new NumberFormatException("Key parameter is not a number");
      }
    }
  }
}
