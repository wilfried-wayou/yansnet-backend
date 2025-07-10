package com.etsia.common.domain.model.sub;

public record PhoneNumber(String value) {
    public PhoneNumber {
        if (value != null && !value.matches("^\\+?[1-9]\\d{1,14}$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}
