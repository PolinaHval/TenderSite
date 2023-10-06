package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.model.User;
import org.teachmeskills.service.OrganizationService;
import org.teachmeskills.service.TenderService;

import java.util.List;

@Controller
@RequestMapping("/preApplications" )
@RequiredArgsConstructor
public class PreApplicationController {

//  страница будет доступна пользователям с ролью админ
  private final OrganizationService organizationService;

  @GetMapping()
  protected String getListTenders(Model model){
    List<Organization> organizations = organizationService.findOrganizationsByUsersIsNull();
    model.addAttribute("organizations", organizations);
    return "preApplications";
  }

  @DeleteMapping("/{organizationId}")
  protected String deleteUser(@PathVariable("organizationId") Long organizationId) {
    Organization organization = organizationService.getOrganizationById(organizationId);
    organizationService.deleteOrganization(organization);
    return "redirect:/preApplications";
  }

}
