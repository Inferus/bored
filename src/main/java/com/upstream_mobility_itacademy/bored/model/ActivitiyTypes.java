package com.upstream_mobility_itacademy.bored.model;

import com.upstream_mobility_itacademy.bored.util.Generated;

@Generated
public enum ActivitiyTypes {
  EDUCATION("education"),
  RECREATIONAL("recreational"),
  SOCIAL("social"),
  DIY("diy"),
  CHARITY("charity"),
  COOKING("cooking"),
  RELAXATION("relaxation"),
  MUSIC("music"),
  BUSYWORK("busywork");

  private final String type;

  ActivitiyTypes(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
