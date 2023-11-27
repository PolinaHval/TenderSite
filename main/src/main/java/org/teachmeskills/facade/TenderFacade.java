package org.teachmeskills.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Tender;
import org.teachmeskills.service.ApplicationService;
import org.teachmeskills.service.TenderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenderFacade {

  private final TenderService tenderService;
  private final ApplicationService applicationService;

  public Tender getTender(int tenderId) {
    return tenderService.getTenderById(tenderId);
  }

  public List<Application> getApplications(int tenderId) {
    return applicationService.getListApplicationsByTender(tenderId);
  }

  public int getCountApplications(Tender tender) {
    return applicationService.count(tender);
  }

}
