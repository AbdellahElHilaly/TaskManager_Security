package com.youcode.taskmanager.common.validation.annotaion;

import com.youcode.taskmanager.common.validation.custom.PresentOr2DaysFutureValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PresentOr2DaysFutureValidator.class)
public @interface PresentOr2DaysFuture {
    String message() default "Date should be today or tomorrow or after tomorrow";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
