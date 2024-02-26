package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.dto.CreateUserDto;
import org.teachmeskills.facade.RegistrationUserFacade;
import org.teachmeskills.model.Organization;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationUserController {

  private final RegistrationUserFacade registrationUserFacade;

  @GetMapping("/{organizationId}")
  protected String doGet(@PathVariable("organizationId") long organizationId, final Model model) {
    Organization organization = registrationUserFacade.getOrganization(organizationId);
    model.addAttribute("organization", organization);
    model.addAttribute("createUserDto", new CreateUserDto());
    return "registration";
  }

  @PostMapping( path = ("/{organizationId}"), consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createUser(@PathVariable("organizationId") long organizationId,
                              @ModelAttribute("createUserDto") @Valid final CreateUserDto createUserDto,
                              final BindingResult result, final  Model model) {
    final Organization organization = registrationUserFacade.getOrganization(organizationId);
    if (!result.hasErrors()) {
      registrationUserFacade.createUser(createUserDto, organization);
        return "redirect:/login";
    } else {
      model.addAttribute("organization", organization);
      return "registration";
    }
  }
}

