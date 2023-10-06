package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.dto.CreateTenderDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.service.TenderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/createTender")
@RequiredArgsConstructor
public class CreateTenderController {

  private final TenderService tenderService;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("createTenderDto", new CreateTenderDto());
    return "createTender";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createTender(@ModelAttribute("createTenderDto") @Valid final CreateTenderDto createTenderDto,
                                final BindingResult result) {
    if (!result.hasErrors()) {
      Organization organization = ((MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
          .getOrganization();
      tenderService.createTender(createTenderDto, organization);
    } else {
      return "/createTender";
    }
    return "redirect:/myTenders";
  }

}
