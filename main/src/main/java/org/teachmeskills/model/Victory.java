package org.teachmeskills.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "victories")
@NoArgsConstructor
@NonFinal
@AllArgsConstructor
@Builder
public class Victory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @ManyToOne
  @JoinColumn(name = "organization_Id", nullable = false)
  public Organization victoryOrganization;

  @OneToOne
  @JoinColumn(name = "tender_Id", nullable = false)
  public Tender victoryTender;
}
