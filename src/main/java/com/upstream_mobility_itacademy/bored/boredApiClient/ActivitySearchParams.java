package com.upstream_mobility_itacademy.bored.boredApiClient;

import com.upstream_mobility_itacademy.bored.util.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Generated
@Data
@AllArgsConstructor
public class ActivitySearchParams {

  private String type;
  private String participants;
  private String price;
  private String accessibility;
  private String key;
  private String minprice;
  private String maxprice;
  private String minaccessibility;
  private String maxaccessibility;

  public String[] getActivitySerachParamsList() {
    return new String[] {
      type,
      participants,
      price,
      accessibility,
      key,
      minprice,
      maxprice,
      minaccessibility,
      maxaccessibility,
    };
  }
}
