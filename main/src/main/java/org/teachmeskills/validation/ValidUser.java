package org.teachmeskills.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.PARAMETER)
@Retention(RUNTIME)
@Constraint(validatedBy = UserValidator.class)
@Documented
public @interface ValidUser {
  String message() default "Данные введены некорректно";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
