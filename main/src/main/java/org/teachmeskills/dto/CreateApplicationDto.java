package org.teachmeskills.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateApplicationDto {

  @NotNull
  private Integer unitPrice;

  @NotNull
  private Integer totalCost;

}
