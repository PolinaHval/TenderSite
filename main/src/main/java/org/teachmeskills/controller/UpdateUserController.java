package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.dto.UpdateUserDto;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;


@Controller
@RequestMapping("/updateUser")
@RequiredArgsConstructor
public class UpdateUserController {

  private final UserService userService;

  @GetMapping("/{userId}")
  protected String doGet (@PathVariable("userId") int userId, Model model) {
    User user = userService.getUserById(userId);
    model.addAttribute("updateUserDto", new UpdateUserDto());
    model.addAttribute("user", user);
    return "updateUser";
  }

  @PostMapping(path =("/{userId}"),consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String updateUser(@PathVariable("userId") int userId,@ModelAttribute("updateUserDto") final UpdateUserDto updateUserDto,
                              final BindingResult result) {
    if (!result.hasErrors()) {
      userService.updateUser(updateUserDto,userId);
      return "redirect:/users";
    } else {
      return "updateUser";
    }
  }
}
