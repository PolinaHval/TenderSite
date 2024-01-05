package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.teachmeskills.dto.CreateUserDto;
import org.teachmeskills.dto.UpdateUserDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.User;
import org.teachmeskills.repository.UserRepository;
import org.teachmeskills.validation.ValidUser;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
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

  public User createUser(@ValidUser CreateUserDto userDto, Organization organization) {
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

  public Page<User> findPaginatedAllUsers(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return userRepository.findAll(pageable);
  }

  public void updateUser(UpdateUserDto updateUserDto, int userId) {

    final User user = userRepository.findUserById(userId);
    user.setName(updateUserDto.getName());
    user.setLastName(user.getLastName());
    user.setPatronymic(user.getPatronymic());
    user.setPhone(user.getPhone());
    user.setJobTitle(user.getJobTitle());
    userRepository.save(user);

  }
}