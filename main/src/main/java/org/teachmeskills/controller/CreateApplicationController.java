package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.dto.CreateApplicationDto;
import org.teachmeskills.facade.ApplicationFacade;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;


import javax.validation.Valid;

@Controller
@RequestMapping("/createApplication")
@RequiredArgsConstructor
public class CreateApplicationController {
  private final ApplicationFacade applicationFacade;

  @GetMapping("/{tenderId}")
  protected String doGet(@PathVariable("tenderId") int tenderId, final Model model) {
    Tender tender = applicationFacade.getTender(tenderId);
    model.addAttribute("tender", tender);
    model.addAttribute("createApplicationDto", new CreateApplicationDto());
    return "/createApplication";
  }

  @PostMapping(path = "/{tenderId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createApplication(@PathVariable("tenderId") int tenderId,
                                     @ModelAttribute("createApplicationDto") @Valid final CreateApplicationDto createApplicationDto,
                                     final BindingResult result, final Model model) {
    Tender tender = applicationFacade.getTender(tenderId);
    if (!result.hasErrors()) {
      Organization organization = ((MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
          .getOrganization();
      applicationFacade.createApplication(createApplicationDto, organization, tender);
    } else {
      model.addAttribute("tender", tender);
      return "/createApplication";
    }
    return "redirect:/tender/" + tenderId;
  }

}
