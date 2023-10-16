package org.teachmeskills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin/allUsers")
@RequiredArgsConstructor
public class UsersController {

  private final UserService userService;


  @GetMapping()
  protected String getListOrganizations(@RequestParam(defaultValue = "1", name = "page", required = false) Integer pageNo,
                                        @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize,
                                        Model model) {
    final Page<User> page = userService.findPaginatedAllUsers(pageNo, pageSize);
    List<User> listUsers = page.getContent();
    model.addAttribute("listUsers", listUsers);
    model.addAttribute("currentPage", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    return "allUsers";
  }
}
