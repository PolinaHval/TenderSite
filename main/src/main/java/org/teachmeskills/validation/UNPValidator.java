package org.teachmeskills.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UNPValidator implements ConstraintValidator<ValidUNP, Integer> {

  @Override
  public boolean isValid(Integer contactField, ConstraintValidatorContext cxt) {
    return contactField != null && (contactField.toString().length() == 9);
  }
}
