package org.teachmeskills.validation;

import lombok.RequiredArgsConstructor;
import org.teachmeskills.dto.CreateUserDto;
import org.teachmeskills.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@RequiredArgsConstructor
public class UserValidator implements ConstraintValidator<ValidUser, Object> {

  private final UserRepository userRepository;


  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
    CreateUserDto createUserDto = (CreateUserDto) obj;

    constraintValidatorContext.disableDefaultConstraintViolation();

    if (userRepository.findByUsername(createUserDto.getUsername()).isPresent()){
      customMessageForValidation(constraintValidatorContext,"Логин пользователя существует");
      return false;
      }
    if (userRepository.findByEmail(createUserDto.getEmail()).isPresent()) {
      customMessageForValidation(constraintValidatorContext,"Почта существует");
      return false;
    }
      return true;
  }

  private void customMessageForValidation(ConstraintValidatorContext constraintContext, String message) {
    constraintContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
  }


}
