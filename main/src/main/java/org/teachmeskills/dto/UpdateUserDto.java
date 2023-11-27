package org.teachmeskills.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UpdateUserDto {

  @NotEmpty(message = "Поле не может быть пустым")
  private String name;

  @NotEmpty(message = "Поле не может быть пустым")
  private String lastName;

  private String patronymic;

  @NotEmpty(message = "Поле не может быть пустым")
  private String phone;

  @NotEmpty(message = "Поле не может быть пустым")
  private String jobTitle;

}
