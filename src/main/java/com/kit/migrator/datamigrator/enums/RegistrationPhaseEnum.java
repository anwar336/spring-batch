package com.kit.migrator.datamigrator.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RegistrationPhaseEnum {
    PARENT,
    AF;

    @JsonCreator
    public static RegistrationPhaseEnum fromValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return RegistrationPhaseEnum.valueOf(value.toUpperCase());
    }
}
