package com.upstream_mobility_itacademy.bored.boredShell;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;
import com.upstream_mobility_itacademy.bored.boredApiClient.BoredApiClient;
import com.upstream_mobility_itacademy.bored.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("Bored commands")
public class BoredShell {

  @Autowired
  private BoredApiClient boredClient;

  @ShellMethod("Gets an activity")
  public String getActivity(
    @ShellOption(
      defaultValue = "",
      valueProvider = ActivityTypeValueProvider.class
    ) String type,
    @ShellOption(defaultValue = "") String key,
    @ShellOption(defaultValue = "") String participants,
    @ShellOption(defaultValue = "") String price,
    @ShellOption(defaultValue = "") String accessability,
    @ShellOption(defaultValue = "") String link
  ) {
    ActivitySearchParams activitySearchParams = new ActivitySearchParams(
      type,
      participants,
      price,
      accessability,
      link,
      key
    );

    try {
      InputValidator.validateSearchParams(activitySearchParams);
    } catch (Exception e) {
      return e.getMessage();
    }

    return boredClient.getActivity(activitySearchParams);
  }
}
