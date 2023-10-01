//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.teachmeskills.model.Application;
//import org.teachmeskills.model.Tender;
//import org.teachmeskills.model.User;
//import org.teachmeskills.service.ApplicationService;
//import org.teachmeskills.service.TenderService;
//import org.teachmeskills.service.UserService;
//import org.teachmeskills.session.AuthContext;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/tender")
//@RequiredArgsConstructor
//public class TenderController {
//
//  private final TenderService tenderService;
//  private final UserService userService;
//  private final AuthContext authContext;
//  private final ApplicationService applicationService;
//
//  @GetMapping("/{tenderId}")
//  protected String getTender(@PathVariable("tenderId") int tenderId, Model model) {
//    final long userId = authContext.getLoggedInUserId();
//    User user = userService.getUserById(userId);
//    Tender tender = tenderService.getTenderById(tenderId);
//    List<Application> applications = applicationService.getListApplicationsByTender(tenderId);
//    int countApplication = applicationService.count(tender);
//    model.addAttribute("user", user);
//    model.addAttribute("tender", tender);
//    model.addAttribute("applications", applications);
//    model.addAttribute("count", countApplication);
//    return "/tender";
//  }
//
//}
