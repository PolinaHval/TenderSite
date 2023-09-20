package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.dto.CreateTenderDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.User;
import org.teachmeskills.service.OrganizationService;
import org.teachmeskills.service.TenderService;
import org.teachmeskills.service.UserService;
import org.teachmeskills.session.AuthContext;

import javax.validation.Valid;

@Controller
@RequestMapping("/createTender")
@RequiredArgsConstructor
public class CreateTenderController {

  private final TenderService tenderService;
  private final AuthContext authContext;
  private final UserService userService;
  private final OrganizationService organizationService;

  @GetMapping
  protected String doGet(final Model model) {
    final long userId = authContext.getLoggedInUserId();
    User user = userService.getUserById(userId);
    model.addAttribute("user", user);
    model.addAttribute("createTenderDto", new CreateTenderDto());
    return "createTender";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createTender(@ModelAttribute("createTenderDto") @Valid final CreateTenderDto createTenderDto,
                                final BindingResult result) {
    final long organizationId = authContext.getOrganizationId();
    final Organization organization = organizationService.getOrganizationById(organizationId);
    if (!result.hasErrors()) {
      tenderService.createTender(createTenderDto, organization);
    } else {
      return "/createTender";
    }
    return "redirect:/myTenders";
  }

}
