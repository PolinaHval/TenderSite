package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.dto.CreateOrganizationDto;
import org.teachmeskills.error.OrganizationAlreadyExistException;
import org.teachmeskills.model.Organization;
import org.teachmeskills.repository.OrganizationRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrganizationService {
  private final OrganizationRepository organizationRepository;


  public void createOrganization(CreateOrganizationDto organizationDto) {

    if (organizationRepository.findByUnp(organizationDto.getUnp()).isPresent()) {
      throw new OrganizationAlreadyExistException("Компания с таким УНП уже существует");
    }
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


  public void deleteOrganization (Organization organization) {
    organizationRepository.delete(organization);
  }
}
