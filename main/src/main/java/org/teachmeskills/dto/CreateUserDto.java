package org.teachmeskills.dto;


import lombok.Data;
import org.teachmeskills.validation.PasswordMatches;
import org.teachmeskills.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@PasswordMatches
public class CreateUserDto {

  @NotEmpty(message = "Поле не может быть пустым")
  private String name;

  @NotEmpty(message = "Поле не может быть пустым")
  private String password;
  private String passwordMatches;

  @NotEmpty(message = "Поле не может быть пустым")
  private String lastName;

  private String patronymic;

  @ValidEmail
  @NotEmpty(message = "Поле не может быть пустым")
  private String email;

  @NotEmpty(message = "Поле не может быть пустым")
  private String phone;

  @NotEmpty(message = "Поле не может быть пустым")
  private String username;

  @NotEmpty(message = "Поле не может быть пустым")
  private String jobTitle;

  @NotEmpty(message = "Поле не может быть пустым")
  private String role;
}
