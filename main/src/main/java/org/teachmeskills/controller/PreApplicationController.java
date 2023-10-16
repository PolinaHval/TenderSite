package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.model.Organization;
import org.teachmeskills.service.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/admin/preApplications" )
@RequiredArgsConstructor
public class PreApplicationController {

  private final OrganizationService organizationService;

  @GetMapping()
  protected String getListPreRegistrations(Model model){
    List<Organization> organizations = organizationService.findOrganizationsByUsersIsNull();
    model.addAttribute("organizations", organizations);
    return "preApplications";
  }

  @DeleteMapping("/{organizationId}")
  protected String deletePreApplication(@PathVariable("organizationId") Long organizationId) {
    Organization organization = organizationService.getOrganizationById(organizationId);
    organizationService.deleteOrganization(organization);
    return "redirect:/admin/preApplications";
  }

}
