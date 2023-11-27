package org.teachmeskills.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.dto.CreateApplicationDto;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.service.ApplicationService;
import org.teachmeskills.service.TenderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationFacade {

  private final ApplicationService applicationService;
  private final TenderService tenderService;

  public Tender getTender(int tenderId) {
    return tenderService.getTenderById(tenderId);
  }

  public void createApplication(CreateApplicationDto createApplicationDto, Organization organization, Tender tender){
   applicationService.createApplication(createApplicationDto, organization, tender);
  }


  public List<Application> getApplications(int tenderId) {
     return applicationService.getListApplicationsByTender(tenderId);
  }
}
