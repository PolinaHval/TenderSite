package org.teachmeskills.config.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.teachmeskills.model.Organization;


import java.util.Collection;

public class CustomUser implements UserDetails {

  private Collection<? extends GrantedAuthority> authorities;
  private final String username;
  private final String password;
  private final Organization organization;
  private final String name;
  private final String lastName;
  private final String patronymic;
  private final String email;
  private final String jobTitle;
  private final int phone;


  public CustomUser(Collection<? extends GrantedAuthority> authorities, String username, String password, Organization organization, String name, String lastName,
                    String patronymic, String email, String jobTitle, int phone) {
    this.authorities = authorities;
    this.username = username;
    this.password = password;
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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getUsername() {
    return username;
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

  @Override
  public String getPassword() {
    return password;
  }
  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
