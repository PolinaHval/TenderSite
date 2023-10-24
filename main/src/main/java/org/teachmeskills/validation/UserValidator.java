package org.teachmeskills.validation;

import lombok.RequiredArgsConstructor;
import org.teachmeskills.dto.CreateUserDto;
import org.teachmeskills.error.UserAlreadyExistException;
import org.teachmeskills.error.UserNameExistException;
import org.teachmeskills.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@RequiredArgsConstructor
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class UserValidator implements ConstraintValidator<ValidUser, Object> {

  private final UserRepository userRepository;

  @Override
  public void initialize(ValidUser constraintAnnotation) {
  }

  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
    CreateUserDto createUserDto = (CreateUserDto) obj;
    if (userRepository.findByEmail(createUserDto.getEmail()).isPresent()) {
      throw new UserAlreadyExistException("Пользователь с указанной почтой существует");
    }
    if (userRepository.findByUsername(createUserDto.getUsername()).isPresent()) {
      throw new UserNameExistException("Пользователь с указанным логином существует");
    }
      return true;
  }
}
