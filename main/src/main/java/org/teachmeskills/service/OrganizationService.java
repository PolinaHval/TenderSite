package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.teachmeskills.dto.CreateOrganizationDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.repository.OrganizationRepository;
import org.teachmeskills.validation.ValidOrganization;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Validated
public class OrganizationService {
  private final OrganizationRepository organizationRepository;


  public void createOrganization(@ValidOrganization CreateOrganizationDto organizationDto) {

    final Organization organization = Organization.builder()
        .unp(organizationDto.getUnp())
        .fullName(organizationDto.getFullName())
        .shortName(organizationDto.getShortName())
        .legalAddress(organizationDto.getLegalAddress())
        .actualAddress(organizationDto.getActualAddress())
        .build();
    organizationRepository.save(organization);
  }

  public Organization getOrganizationById(long organizationId) {
    return organizationRepository.getOrganizationById(organizationId);
  }

  public Optional<Organization> findOrganizationById(long organizationId) {
    return organizationRepository.findOrganizationById(organizationId);
  }

  public Organization findOrganizationByUnp(int unp) {
    return organizationRepository.getByUnp(unp);
  }

  public List<Organization> findOrganizationsByUsersIsNull(){
    return organizationRepository.findOrganizationsByUsersIsNull();
  }
  public Page<Organization> findPaginatedAllOrganizations(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return organizationRepository.findAll(pageable);
  }

  public void deleteOrganization (Organization organization) {
    organizationRepository.delete(organization);
  }
}
