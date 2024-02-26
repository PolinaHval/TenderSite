package org.teachmeskills.config.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;

import java.util.Collection;

public class MyUser extends User {

  private final Organization organization;
  private final String name;
  private final String lastName;
  private final String patronymic;
  private final String email;
  private final String jobTitle;
  private final String phone;
  private final long id;
  private final Role role;

  public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                Organization organization, String name, String lastName, String patronymic,
                String email, String jobTitle, String phone, long id, Role role) {
    super(username, password, authorities);
    this.organization = organization;
    this.name = name;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.jobTitle = jobTitle;
    this.phone = phone;
    this.id = id;
    this.role = role;
  }

  public Role getRole() {
    return role;
  }

  public long getId() {
    return id;
  }

  public Organization getOrganization() {
    return organization;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public String getEmail() {
    return email;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public String getPhone() {
    return phone;
  }
}

