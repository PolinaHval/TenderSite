package org.teachmeskills.config.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.teachmeskills.model.User;
import org.teachmeskills.service.UserService;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SpringSecurityUserService implements UserDetailsService {

  private final UserService userService;

  @Override
  public MyUser loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userService.getUserLogin(username);
    return new MyUser(user.getUsername(),user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName())),
        user.getOrganization(), user.getName(), user.getLastName(), user.getPatronymic(), user.getEmail(),
        user.getJobTitle(), user.getPhone(), user.getId(), user.getRole());
  }
}
