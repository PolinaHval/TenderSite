package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teachmeskills.dto.UserDto;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final UserService userService;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("userDto", new UserDto());
    return "login";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String loginUser (@ModelAttribute("userDto") @Valid final UserDto userDto, final BindingResult result) {
    if (!result.hasErrors()) {
      final String username = userDto.getUsername();
      final String password = userDto.getPassword();
      Optional<User> user = userService.findUser(username);
      if (user.isPresent() && userService.validatePassword(password, user.get().getPassword())) {
        return "redirect:/homePage";
      }
    }
    return "login";
  }
}

