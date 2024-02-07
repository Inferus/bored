package com.upstream_mobility_itacademy.bored.validator;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;

public class InputValidator {
    static public void validateSearchParams(ActivitySearchParams activitySearchParams) throws NumberFormatException{

                activitySearchParams.getType();
                Integer.parseInt(activitySearchParams.getParticipants());
                Float.parseFloat(activitySearchParams.getPrice());
                Float.parseFloat(activitySearchParams.getAccessibility());
                activitySearchParams.getLink();
                Integer.parseInt(activitySearchParams.getKey());


    }
}
