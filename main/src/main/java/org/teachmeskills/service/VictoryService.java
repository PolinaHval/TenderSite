package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.model.Victory;
import org.teachmeskills.repository.VictoryRepository;


@Service
@RequiredArgsConstructor
public class VictoryService {

  private final VictoryRepository victoryRepository;


  public void createVictory(Organization organization, Tender tender) {

    final Victory victory = Victory.builder().victoryOrganization(organization).victoryTender(tender).build();
    victoryRepository.save(victory);
  }


}
