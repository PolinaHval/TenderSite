package org.teachmeskills.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UserDto {

  @NotEmpty(message = "Поле не может быть пустым")
  private String login;

  @NotEmpty(message = "Поле не может быть пустым")
  private String password;

}
