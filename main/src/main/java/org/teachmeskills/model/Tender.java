package org.teachmeskills.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tenders")
@Builder
@AllArgsConstructor
public class Tender {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "subject")
  String subject;

  @Column(name = "short_Description")
  String shortDescription;

  @Column(name = "valuta")
  String valuta;

  @Column(name = "amount")
  int amount;

  @Column(name = "unit_Of_Measurement")
  String unitOfMeasurement;

  @Column(name = "unit_Price")
  int unitPrice;

  @Column(name = "total_Cost")
  int totalCost;

  @Column(name = "terms_Of_Payment")
  String termsOfPayment;

  @Column(name = "delivery_Conditions")
  String deliveryConditions;

  @ManyToOne
  @JoinColumn(name = "organization_Id", nullable = false)
  public Organization organizationTenders;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tender")
  private List<Application> applications;

  @OneToOne(mappedBy = "victoryTender")
  private Victory victory;
}
