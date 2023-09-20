package org.teachmeskills.dto;


import lombok.Data;
import org.teachmeskills.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CreateUserDto {

  @NotEmpty(message = "Поле не может быть пустым")
  private String name;

  @NotEmpty(message = "Поле не может быть пустым")
  private String password;

  @NotEmpty(message = "Поле не может быть пустым")
  private String lastName;

  private String patronymic;

  @ValidEmail
  @NotEmpty(message = "Поле не может быть пустым")
  private String email;

  @NotNull(message = "Поле не может быть пустым")
  private int phone;

  @NotEmpty(message = "Поле не может быть пустым")
  private String login;

  @NotEmpty(message = "Поле не может быть пустым")
  private String jobTitle;

  @NotEmpty(message = "Поле не может быть пустым")
  private String role;
}
