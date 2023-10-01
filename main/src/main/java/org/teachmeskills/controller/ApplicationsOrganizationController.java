//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.teachmeskills.model.Application;
//import org.teachmeskills.service.ApplicationService;
//import org.teachmeskills.session.AuthContext;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/myApplications")
//@RequiredArgsConstructor
//public class ApplicationsOrganizationController {
//  private final AuthContext authContext;
//  private final ApplicationService applicationService;
//
//  @GetMapping
//  protected String listApplications(final Model model) {
//    final long organizationId = authContext.getOrganizationId();
//    List<Application> applications = applicationService.getListApplications(organizationId);
//    model.addAttribute("applications", applications);
//    return "myApplications";
//  }
//
//  @DeleteMapping("/{applicationId}")
//  protected String deleteApplication(@PathVariable("applicationId") long applicationId) {
//    Application application = applicationService.getApplicationById(applicationId);
//    applicationService.deleteTender(application);
//    return "redirect:/myApplications";
//  }
//
//}
