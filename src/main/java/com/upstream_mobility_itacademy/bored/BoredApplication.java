package com.upstream_mobility_itacademy.bored;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
  {
    "com.upstream_mobility_itacademy.bored.boredApiClient",
    "com.upstream_mobility_itacademy.bored.config",
    "com.upstream_mobility_itacademy.bored.boredShell",
  }
)
public class BoredApplication {

  public static void main(String[] args) {
    SpringApplication.run(BoredApplication.class, args);
  }
}
