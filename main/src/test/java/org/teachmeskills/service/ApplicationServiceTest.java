package org.teachmeskills.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.repository.ApplicationRepository;
import org.teachmeskills.service.ApplicationService;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

  @InjectMocks
  private ApplicationService applicationService;

  @Mock
  private ApplicationRepository  applicationRepository;

  @Mock
  private Tender tender;
  @Mock
  private Organization organization;
  @Test
  public void getApplicationByIdTest(){

    long applicationId = 1;
    Application created = new Application(1,2,4,organization,tender);

    given(applicationService.getApplicationById(applicationId)).willReturn(created);
    Application expected = applicationService.getApplicationById(applicationId);

    assertEquals(expected,created);
  }
}



