package com.upstream_mobility_itacademy.bored.boredShell;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;
import com.upstream_mobility_itacademy.bored.boredApiClient.BoredApiClient;
import com.upstream_mobility_itacademy.bored.util.Generated;
import com.upstream_mobility_itacademy.bored.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Generated
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
    @ShellOption(defaultValue = "") String minprice,
    @ShellOption(defaultValue = "") String maxprice,
    @ShellOption(defaultValue = "") String minaccessibility,
    @ShellOption(defaultValue = "") String maxaccessibility
  ) {
    ActivitySearchParams activitySearchParams = new ActivitySearchParams(
      type,
      participants,
      price,
      accessability,
      key,
      minprice,
      maxprice,
      minaccessibility,
      maxaccessibility
    );

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
