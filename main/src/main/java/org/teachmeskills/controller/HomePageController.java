package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;


@Controller
@RequestMapping("/homePage")
@RequiredArgsConstructor
public class HomePageController {
  private final UserService userService;

  @GetMapping()
  protected String getUser() {
//    final long userId = authContext.getLoggedInUserId();
//    User user = userService.getUserById(userId);
//    model.addAttribute("user", user);
    return "homePage";
  }
}
