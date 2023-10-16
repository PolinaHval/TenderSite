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
import org.teachmeskills.service.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/admin/allOrganizations")
@RequiredArgsConstructor
public class OrganizationsController {
  private final OrganizationService organizationService;

  @GetMapping()
  protected String getListOrganizations(@RequestParam(defaultValue = "1", name = "page", required = false) Integer pageNo,
                                  @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
                                  Model model) {
    final Page<Organization> page = organizationService.findPaginatedAllOrganizations(pageNo, pageSize);
    List<Organization> listOrganizations = page.getContent();
    model.addAttribute("listOrganizations", listOrganizations);
    model.addAttribute("currentPage", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    return "allOrganizations";
  }

  @DeleteMapping("/{organizationId}")
  protected String deleteOrganization(@PathVariable("organizationId") Long userId) {
    Organization organization = organizationService.getOrganizationById(userId);
    organizationService.deleteOrganization(organization);
    return "redirect:/admin/allOrganizations";
  }
}
