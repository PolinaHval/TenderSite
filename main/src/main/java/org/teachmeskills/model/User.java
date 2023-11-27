package org.teachmeskills.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@NonFinal
@AllArgsConstructor
@Builder

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "username")
  String username;

  @Column(name = "password")
  String password;

  @Column(name = "name")
  String name;

  @Column(name = "last_Name")
  String lastName;

  @Column(name = "patronymic")
  String patronymic;

  @Column(name = "email")
  String email;

  @Column(name = "phone")
  String phone;

  @Column(name = "job_Title")
  String jobTitle;

  @ManyToOne
  @JoinColumn(name = "organization_Id", nullable = false)
  public Organization organization;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_Id", nullable = false)
  public Role role;

  public User(String username, String password, String name, String lastName, String patronymic, String email, String phone,
              String jobTitle, Organization organization, Role role) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.phone = phone;
    this.jobTitle = jobTitle;
    this.organization = organization;
    this.role = role;

  }
}
