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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "organizations")
@Builder
@AllArgsConstructor
public class Organization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "unp")
  int unp;

  @Column(name = "full_Name")
  String fullName;

  @Column(name = "short_Name")
  String shortName;

  @Column(name = "legal_Address")
  String legalAddress;

  @Column(name = "actual_Address")
  String actualAddress;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "organization")
  private List<User> users;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "organizationTenders")
  private List<Tender> tenders;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "organizationApplication")
  private List<Application> applications;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "victoryOrganization")
  private List<Victory> victories;
}
