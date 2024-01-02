package com.youcode.taskmanager.common.validation.custom;

import com.youcode.taskmanager.common.validation.annotaion.UUIDFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<UUIDFormat, UUID> {
    @Override
    public void initialize(UUIDFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            UUID.fromString(value.toString());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
