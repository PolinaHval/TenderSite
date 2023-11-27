package org.teachmeskills.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.service.ApplicationService;
import org.teachmeskills.service.TenderService;
import org.teachmeskills.service.VictoryService;

@Service
@RequiredArgsConstructor
public class VictoryFacade {

  private final ApplicationService applicationService;
  private final VictoryService victoryService;

  public Application getApplication(int applicationId){
    return applicationService.getApplicationById(applicationId);
  }

  public void createVictory(Organization organization, Tender tender){
    victoryService.createVictory(organization, tender);
  }
}
