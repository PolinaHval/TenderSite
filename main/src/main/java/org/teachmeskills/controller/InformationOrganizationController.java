//package org.teachmeskills.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.teachmeskills.model.User;
//import org.teachmeskills.service.UserService;
//import org.teachmeskills.session.AuthContext;
//
//@Controller
//@RequestMapping("/organization")
//@RequiredArgsConstructor
//public class InformationOrganizationController {
//
//  private final UserService userService;
//  private final AuthContext authContext;
//
//  @GetMapping()
//  protected String getUserById(Model model) {
//    final long userId = authContext.getLoggedInUserId();
//    User user = userService.getUserById(userId);
//    model.addAttribute("user", user);
//    return "organization";
//
//  }
//
//}
