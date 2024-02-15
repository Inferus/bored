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
      "123",
      "123",
      "123",
      "123",
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
      "123",
      "123",
      "123",
      "123",
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
      "123",
      "123",
      "123",
      "123",
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
      "123",
      "123",
      "123",
      "123",
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
      "123",
      "123",
      "123",
      "123",
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
      "123",
      "123",
      "123",
      "123",
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
      "ff",
      "123",
      "123",
      "123",
      "123"
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
      "123",
      "123",
      "123",
      "123",
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
      "123",
      "123",
      "123",
      "123",
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
      "",
      "123",
      "123",
      "123",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyMinprice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "",
      "123",
      "123",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyMaxprice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "123",
      "",
      "123",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyMinaccessibility() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "123",
      "123",
      "",
      "123"
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithEmptyMaxaccessibility() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "123",
      "123",
      "123",
      ""
    );

    assertDoesNotThrow(() -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidMinprice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "ff",
      "123",
      "123",
      "123"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidMaxprice() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "123",
      "ff",
      "123",
      "123"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidMinaccessibility() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "123",
      "123",
      "ff",
      "123"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }

  @Test
  public void testValidateSearchParamsWithInvalidMaxaccessibility() {
    ActivitySearchParams invalidParams = new ActivitySearchParams(
      "education",
      "1",
      "10.5",
      "0.8",
      "123",
      "123",
      "123",
      "123",
      "ff"
    );

    assertThrows(
      NumberFormatException.class,
      () -> InputValidator.validateSearchParams(invalidParams)
    );
  }
}
