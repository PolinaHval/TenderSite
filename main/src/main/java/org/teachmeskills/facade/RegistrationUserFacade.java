package org.teachmeskills.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.dto.CreateUserDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.service.OrganizationService;
import org.teachmeskills.service.UserService;

@Service
@RequiredArgsConstructor
public class RegistrationUserFacade {

  private final UserService userService;
  private final OrganizationService organizationService;


  public Organization getOrganization (long organizationId){
    return  organizationService.getOrganizationById(organizationId);
  }

   public void createUser (CreateUserDto createUserDto, Organization organization) {
    userService.createUser(createUserDto, organization);
   }
}
