package org.teachmeskills.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateOrganizationDto {

  @NotNull
  private Integer unp;

  @NotEmpty(message = "Поле не может быть пустым")
  private String fullName;

  @NotEmpty(message = "Поле не может быть пустым")
  private String shortName;

  @NotEmpty(message = "Поле не может быть пустым")
  private String legalAddress;

  @NotEmpty(message = "Поле не может быть пустым")
  private String actualAddress;

}
