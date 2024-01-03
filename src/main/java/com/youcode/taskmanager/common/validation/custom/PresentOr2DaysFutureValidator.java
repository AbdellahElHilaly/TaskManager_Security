package com.youcode.taskmanager.common.validation.custom;

import com.youcode.taskmanager.common.validation.annotaion.PresentOr2DaysFuture;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PresentOr2DaysFutureValidator implements ConstraintValidator<PresentOr2DaysFuture, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate afterTomorrow = today.plusDays(2);

        return value.isEqual(today) || value.isEqual(tomorrow) || value.isEqual(afterTomorrow) || value.isAfter(afterTomorrow);
    }
}
