package org.teachmeskills.validation;

import lombok.RequiredArgsConstructor;
import org.teachmeskills.dto.CreateOrganizationDto;
import org.teachmeskills.repository.OrganizationRepository;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class OrganizationValidator implements ConstraintValidator<ValidOrganization, Object> {

  private final OrganizationRepository organizationRepository;


  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
    CreateOrganizationDto createOrganizationDto = (CreateOrganizationDto) obj;

    constraintValidatorContext.disableDefaultConstraintViolation();

    if (organizationRepository.findByUnp(createOrganizationDto.getUnp()).isPresent()) {
      constraintValidatorContext.buildConstraintViolationWithTemplate("Компания с таким УНП существует.")
          .addConstraintViolation()
          .disableDefaultConstraintViolation();
      return false;
    }
    return true;
  }

}
