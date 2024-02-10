package com.upstream_mobility_itacademy.bored.validator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.upstream_mobility_itacademy.bored.boredApiClient.ActivitySearchParams;
import org.junit.jupiter.api.Test;

public class InputValidatorUTests {

  @Test
  public void testValidateSearchParamsWithValidData() {
    ActivitySearchParams validParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "https://www.example.com",
      "123"
    );
    assertDoesNotThrow(() -> InputValidator.validateSearchParams(validParams));
  }

  @Test
  public void testValidateSearchParamsWithEmptyParticipants() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "",
      "10.5",
      "0.8",
      "https://www.example.com",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidParticipants() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "ff",
      "10.5",
      "0.8",
      "https://www.example.com",
      "123"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithNullPrice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      null,
      "0.8",
      "https://www.example.com",
      "123"
    );

    assertThrows(
      Exception.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidPrice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "ff",
      "0.8",
      "https://www.example.com",
      "123"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidAccessibility() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "ff",
      "https://www.example.com",
      "123"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidKey() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "https://www.example.com",
      "ff"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyPrice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "",
      "0.8",
      "https://www.example.com",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyAccessibility() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "",
      "https://www.example.com",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyKey() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "https://www.example.com",
      ""
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }
}
