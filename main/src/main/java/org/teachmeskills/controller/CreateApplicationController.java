//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.teachmeskills.dto.CreateApplicationDto;
//import org.teachmeskills.model.Organization;
//import org.teachmeskills.model.Tender;
//import org.teachmeskills.model.User;
//import org.teachmeskills.service.ApplicationService;
//import org.teachmeskills.service.OrganizationService;
//import org.teachmeskills.service.TenderService;
//import org.teachmeskills.service.UserService;
//import org.teachmeskills.session.AuthContext;
//
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/createApplication")
//@RequiredArgsConstructor
//public class CreateApplicationController {
//
//  private final AuthContext authContext;
//  private final UserService userService;
//  private final ApplicationService applicationService;
//  private final OrganizationService organizationService;
//  private final TenderService tenderService;
//
//  @GetMapping("/{tenderId}")
//  protected String doGet(@PathVariable("tenderId") int tenderId, final Model model) {
//    final long userId = authContext.getLoggedInUserId();
//    User user = userService.getUserById(userId);
//    Tender tender = tenderService.getTenderById(tenderId);
//    model.addAttribute("user", user);
//    model.addAttribute("tender", tender);
//    model.addAttribute("createApplicationDto", new CreateApplicationDto());
//    return "/createApplication";
//  }
//
//  @PostMapping(path = "/{tenderId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//  protected String createApplication(@PathVariable("tenderId") int tenderId, @ModelAttribute("createApplicationDto") @Valid final CreateApplicationDto createApplicationDto,
//                                final BindingResult result) {
//    final long organizationId = authContext.getOrganizationId();
//    final Organization organization = organizationService.getOrganizationById(organizationId);
//    Tender tender = tenderService.getTenderById(tenderId);
//    if (!result.hasErrors()) {
//      applicationService.createApplication(createApplicationDto, organization, tender);
//    } else {
//      return "/createApplication";
//    }
//    return "redirect:/tender/" + tenderId;
//  }
//
//}
