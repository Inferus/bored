package com.upstream_mobility_itacademy.bored.model;

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

  public String getType() {
    return type;
  }
}
