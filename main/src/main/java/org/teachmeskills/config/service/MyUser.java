package org.teachmeskills.config.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.teachmeskills.model.Organization;

import java.util.Collection;

public class MyUser extends User {

  private final Organization organization;
  private final String name;
  private final String lastName;
  private final String patronymic;
  private final String email;
  private final String jobTitle;
  private final int phone;


  public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                Organization organization, String name, String lastName, String patronymic,
                String email, String jobTitle, int phone) {
    super(username, password, authorities);
    this.organization = organization;
    this.name = name;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.jobTitle = jobTitle;
    this.phone = phone;
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

  public int getPhone() {
    return phone;
  }
}

