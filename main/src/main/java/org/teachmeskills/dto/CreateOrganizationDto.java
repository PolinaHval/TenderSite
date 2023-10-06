package org.teachmeskills.dto;

import lombok.Data;
import org.teachmeskills.validation.ValidUNP;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateOrganizationDto {

  @ValidUNP
  @NotNull (message = "Поле не может быть пустым")
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
