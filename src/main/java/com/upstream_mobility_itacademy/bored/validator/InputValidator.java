package com.upstream_mobility_itacademy.bored.validator;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;

public class InputValidator {
    static public void validateSearchParams(ActivitySearchParams activitySearchParams) throws NumberFormatException{

        
                if (!activitySearchParams.getParticipants().equals("")) {
                    
                    Integer.parseInt(activitySearchParams.getParticipants());
                }

                if (!activitySearchParams.getPrice().equals("")) {
                    Float.parseFloat(activitySearchParams.getPrice());
                }
                if (!activitySearchParams.getAccessibility().equals("")){
                    Float.parseFloat(activitySearchParams.getAccessibility());
                }

                if (!activitySearchParams.getKey().equals("")){

                    Integer.parseInt(activitySearchParams.getKey());
                }
                


    }
}
