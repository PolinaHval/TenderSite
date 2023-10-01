package org.teachmeskills.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.teachmeskills.dto.AppUserDto;
import org.teachmeskills.dto.CreateUserDto;
import org.teachmeskills.error.UserAlreadyExistException;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.User;
import org.teachmeskills.repository.UserRepository;;import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final OrganizationService organizationService;
  private final RoleService roleService;
  private final HashPassword hashPassword;

  public String hashingPassword(String password) {
    return hashPassword.hashingPassword(password);
  }

  public boolean validatePassword(String password, String hashedPassword) {
    return hashPassword.validatePassword(password, hashedPassword);
  }

  public User createUser(CreateUserDto userDto, Organization organization) {

    if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
      throw new UserAlreadyExistException(" Пользователь с указанной почтой существует");
    }
    final Role role = roleService.getRoleByName(userDto.getRole());
    final User user = new User(userDto.getUsername(), hashingPassword(userDto.getPassword()), userDto.getName(),
        userDto.getLastName(), userDto.getPatronymic(), userDto.getEmail(), userDto.getPhone(), userDto.getJobTitle(),
        organization, role);
    return userRepository.save(user);
  }

  public Optional<User> findUser(String username) {
    return userRepository.findByUsername(username);
  }


  public User getUserById(long userId) {
    return userRepository.findUserById(userId);
  }

  public List<User> getUsers(long organizationId) {
    return organizationService.findOrganizationById(organizationId).orElseThrow().getUsers();
  }

  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  public User getUserLogin(String username) {
   return userRepository.getUserByUsername(username);
  }
}
