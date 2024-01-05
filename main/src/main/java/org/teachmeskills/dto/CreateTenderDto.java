package org.teachmeskills.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateTenderDto {

  @NotEmpty
  private String subject;

  @NotEmpty
  private String shortDescription;

  @NotEmpty
  private String valuta;

  @NotNull
  private Integer amount;

  @NotEmpty
  private String unitOfMeasurement;

  @NotNull
  private Integer unitPrice;

  @NotNull
  private Integer totalCost;

  @NotEmpty
  private String termsOfPayment;

  @NotEmpty
  private String deliveryConditions;

  boolean status = true;
}
