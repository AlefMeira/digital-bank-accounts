package com.digitalbank.accounts.usecases.exceptions.enums;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ErrorType {
    DBA001,
    DBA002,
    DBA003,
    DBA004,
    DBA005;

    public String getMessage(final Locale locale) {
        final var bundle = ResourceBundle.getBundle("i18n/exceptions", locale);
        return new String(bundle.getString(this.name() + ".message")
                .getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
    }
}