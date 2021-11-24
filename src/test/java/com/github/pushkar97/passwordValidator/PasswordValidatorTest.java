package com.github.pushkar97.passwordValidator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PasswordValidatorTest {

    PasswordValidator validator;

    @BeforeAll
    public void setup() {
        validator = new PasswordValidator();
    }

    @Test
    public void testSetup() {
        assertThat(validator).isNotNull();
    }

    @Test
    public void whenPasswordIsValid_ThenResultShouldBeTrue() {
        assertThat(validator.isValid("Abcd@123"))
                .matches(v -> v.result, "is Valid")
                .matches(v -> v.validationErrors.isEmpty(), "errors is Empty");
    }

    @Test
    public void whenPasswordLengthLessThan8_ThenThrowError() {
        assertThat(validator.isValid("A@12"))
                .matches(v -> !v.result, "is Not Valid")
                .matches(v -> !v.validationErrors.isEmpty(), "errors is not Empty")
                .extracting(PasswordValidator.ValidationResult::errorMessage)
                .isEqualTo("Password must be at least 8 characters");
    }
    @Test
    public void whenPasswordDoesNotContainAtLeast2Numbers_ThenThrowError() {
        assertThat(validator.isValid("Abcd@erfg"))
                .matches(v -> !v.result, "is Not Valid")
                .matches(v -> !v.validationErrors.isEmpty(), "errors is not Empty")
                .extracting(PasswordValidator.ValidationResult::errorMessage)
                .isEqualTo("The password must contain at least 2 numbers");
    }

    @Test
    public void whenMultipleValidationErrorsPresent_ThenErrosShouldBeSeperatedByNewLine() {
        assertThat(validator.isValid("Aass@"))
                .matches(v -> !v.result, "is Not Valid")
                .matches(v -> !v.validationErrors.isEmpty(), "errors is not Empty")
                .extracting(PasswordValidator.ValidationResult::errorMessage)
                .isEqualTo("Password must be at least 8 characters\nThe password must contain at least 2 numbers");
    }

    @Test
    public void whenCapitalLetterNotPresent_ThenThrowError() {
        assertThat(validator.isValid("pass@1234"))
                .matches(v -> !v.result, "is Not Valid")
                .matches(v -> !v.validationErrors.isEmpty(), "errors is not Empty")
                .extracting(PasswordValidator.ValidationResult::errorMessage)
                .isEqualTo("password must contain at least one capital letter");
    }

    @Test
    public void whenSpecialCharacterNotPresent_ThenThrowError() {
        assertThat(validator.isValid("Pass1234"))
                .matches(v -> !v.result, "is Not Valid")
                .matches(v -> !v.validationErrors.isEmpty(), "errors is not Empty")
                .extracting(PasswordValidator.ValidationResult::errorMessage)
                .isEqualTo("password must contain at least one special character");
    }
}
