package com.upstream_mobility_itacademy.bored.boredApiClient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivitySearchParams {
    private String type;
    private String participants;
    private String price;
    private String accessibility;
    private String link;
    private String key;

}
