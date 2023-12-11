package org.teachmeskills.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.teachmeskills.model.Tender;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TenderRepositoryIntegrationTest extends AbstractIntegrationTenderTest {

  @Autowired
  private TenderRepository tenderRepository;

  @Test
  public void getTenderByIdTest(){
    int tenderId = 1;

    Tender result  = tenderRepository.getTenderById(tenderId);

    assertEquals(result.getId(), tenderId);
  }

  @Test
  public void findTenderByIdTest(){
    int tenderId = 1;

    Optional<Tender> result  = tenderRepository.findTenderById(tenderId);

    assertEquals(result.get().getId(), tenderId);
  }

}
