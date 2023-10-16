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
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersOrganizationController {

  private final UserService userService;

  @GetMapping()
  protected String listUsersOrganization(Model model) {
    final long organizationId = ((MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal())
        .getOrganization().getId();
    List<User> users = userService.getUsers(organizationId);
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

