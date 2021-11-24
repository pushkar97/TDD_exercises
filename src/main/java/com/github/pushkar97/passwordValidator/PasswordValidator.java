package com.github.pushkar97.passwordValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PasswordValidator {

    public ValidationResult isValid(String input) {
        List<String> errors = new ArrayList<>();
        if (input.trim().length() < 8) errors.add("Password must be at least 8 characters");

        long digitCount = input.chars().filter(Character::isDigit).count();
        if(digitCount < 2) errors.add("The password must contain at least 2 numbers");

        long capitalLetterCount = input.chars().filter(Character::isUpperCase).count();
        if(capitalLetterCount < 1) errors.add("password must contain at least one capital letter");

        long specialCharacterCount = input.chars().filter(c -> !Character.isLetterOrDigit(c)).count();
        if(specialCharacterCount < 1) errors.add("password must contain at least one special character");

        return new ValidationResult(errors.isEmpty(), errors);
    }

    public static class ValidationResult {
        boolean result;
        Collection<String> validationErrors;

        public ValidationResult() {
            result = false;
            validationErrors = null;
        }

        public ValidationResult(boolean result, Collection<String> validationErrors) {
            this.result = result;
            this.validationErrors = validationErrors;
        }

        public String errorMessage() {
            return validationErrors.stream().reduce((a,b) -> a + "\n" + b).orElse("");
        }
    }
}
