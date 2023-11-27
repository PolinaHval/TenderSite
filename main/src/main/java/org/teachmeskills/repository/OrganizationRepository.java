package org.teachmeskills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teachmeskills.model.Organization;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

  Optional<Organization> findByUnp(int unp);

  Optional<Organization> findOrganizationById(long organizationId);

  Organization getOrganizationById(long organizationId);

 Organization getByUnp(int unp);

 List<Organization> findOrganizationsByUsersIsNull();
}
