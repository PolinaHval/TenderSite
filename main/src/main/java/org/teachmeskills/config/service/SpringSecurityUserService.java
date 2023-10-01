package org.teachmeskills.config.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class SpringSecurityUserService implements UserDetailsService {

  private final UserService userService;

  @Override
  public MyUser loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userService.getUserLogin(username);
    return new MyUser(user.getUsername(),user.getPassword(), Collections.emptyList(), user.getOrganization(),
        user.getName(), user.getLastName(), user.getPatronymic(), user.getEmail(), user.getJobTitle(), user.getPhone());
  }

//  здесь авторизация не проходит
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    final User user = userService.getUserLogin(username);
//    return new CustomUser (Collections.emptyList(),user.getUsername(), user.getPassword(), user.getOrganization(),
//        user.getName(), user.getLastName(), user.getPatronymic(), user.getEmail(), user.getJobTitle(), user.getPhone());
//  }

}




