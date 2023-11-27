package org.teachmeskills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

  Application findApplicationById(long applicationId);

  int countApplicationByTender(Tender tender);

  Optional<Application> findApplicationByOrganizationApplicationAndTender(Organization organization, Tender tender);


}
