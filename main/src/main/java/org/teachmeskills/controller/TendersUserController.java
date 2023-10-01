//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.teachmeskills.model.Tender;
//import org.teachmeskills.model.User;
//import org.teachmeskills.service.TenderService;
//import org.teachmeskills.service.UserService;
//import org.teachmeskills.session.AuthContext;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/myTenders")
//@RequiredArgsConstructor
//public class TendersUserController {
//  private final TenderService tenderService;
//  private final AuthContext authContext;
//  private final UserService userService;
//
//  @GetMapping
//  protected String getListTendersUser(final Model model) {
//    final long userId = authContext.getLoggedInUserId();
//    final long organizationId = authContext.getOrganizationId();
//    User user = userService.getUserById(userId);
//    List<Tender> tenders = tenderService.getListTenders(organizationId);
//    model.addAttribute("user", user);
//    model.addAttribute("tenders", tenders);
//    return "myTenders";
//  }
//
//  @DeleteMapping("/{tenderId}")
//  protected String deleteUser(@PathVariable("tenderId") int tenderId) {
//    Tender tender = tenderService.getTenderById(tenderId);
//    tenderService.deleteTender(tender);
//    return "redirect:/myTenders";
//  }
//
//}
