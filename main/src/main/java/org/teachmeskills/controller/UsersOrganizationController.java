package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;
import org.teachmeskills.session.AuthContext;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersOrganizationController {

  private final UserService userService;
  private final AuthContext authContext;

  @GetMapping()
  protected String listUsersOrganization(Model model) {
    final long userId = authContext.getLoggedInUserId();
    final long organizationId = authContext.getOrganizationId();
    User user = userService.getUserById(userId);
    List<User> users = userService.getUsers(organizationId);
    model.addAttribute("user", user);
    model.addAttribute("users", users);
    return "users";
  }

  @DeleteMapping("/{userId}")
  protected String deleteUser(@PathVariable("userId") Long userId) {
    User user = userService.getUserById(userId);
    userService.deleteUser(user);
    return "redirect:/users";
  }

}
