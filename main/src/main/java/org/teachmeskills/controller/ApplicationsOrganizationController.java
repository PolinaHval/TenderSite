package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.model.Application;
import org.teachmeskills.service.ApplicationService;

import java.util.List;

@Controller
@RequestMapping("/myApplications")
@RequiredArgsConstructor
public class ApplicationsOrganizationController {
  private final ApplicationService applicationService;

  @GetMapping
  protected String listApplications(final Model model) {
    final long organizationId = ((MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
        .getOrganization().getId();
    List<Application> applications = applicationService.getListApplications(organizationId);
    model.addAttribute("applications", applications);
    return "myApplications";
  }

  @DeleteMapping("/{applicationId}/{tenderId}")
  protected String deleteApplication(@PathVariable("applicationId") long applicationId,
                                     @PathVariable("tenderId") int tenderId) {
    Application application = applicationService.getApplicationById(applicationId);
    applicationService.deleteTender(application);
    return "redirect:/tender/" + tenderId;
  }

}
