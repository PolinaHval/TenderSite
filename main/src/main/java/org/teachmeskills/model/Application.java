package org.teachmeskills.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "applications")
@Builder
@AllArgsConstructor
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "unit_Price")
  int unitPrice;

  @Column(name = "total_Cost")
  int totalCost;

  @ManyToOne
  @JoinColumn(name = "organization_Id", nullable = false)
  public Organization organizationApplication;

  @ManyToOne
  @JoinColumn(name = "tender_Id", nullable = false)
  public Tender tender;

}
