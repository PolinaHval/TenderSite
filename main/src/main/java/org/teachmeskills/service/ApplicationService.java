package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.dto.CreateApplicationDto;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.repository.ApplicationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
  private final ApplicationRepository applicationRepository;
  private final OrganizationService organizationService;
  private final TenderService tenderService;


  public void createApplication(CreateApplicationDto createApplicationDto, Organization organization, Tender tender) {

    if (applicationRepository.findApplicationByOrganizationApplicationAndTender(organization, tender).isPresent()) {
      throw new RuntimeException("Ваша организация уже принимает учвстие в тендере");
    }
    final Application application = Application.builder()
        .unitPrice(createApplicationDto.getUnitPrice())
        .totalCost(createApplicationDto.getTotalCost())
        .organizationApplication(organization)
        .tender(tender)
        .build();
    applicationRepository.save(application);
  }

  public List<Application> getListApplications(long organizationId) {
    return organizationService.findOrganizationById(organizationId).orElseThrow().getApplications();
  }

  public List<Application> getListApplicationsByTender(int tenderId) {
    return tenderService.findTenderById(tenderId).orElseThrow().getApplications();
  }

  public Application getApplicationById(long applicationId) {
    return applicationRepository.findApplicationById(applicationId);
  }

  public int count(Tender tender) {
    return applicationRepository.countApplicationByTender(tender);
  }

  public void deleteTender(Application application) {
    applicationRepository.delete(application);
  }

}
