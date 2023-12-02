package org.teachmeskills.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.teachmeskills.model.Organization;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class OrganizationRepositoryIntegrationTest extends ConfigTest{

  @Autowired
  private OrganizationRepository organizationRepository;


  @Test
  public void findByUnpTest (){
    int unp = 111111111;

    Optional<Organization> result  = organizationRepository.findByUnp(unp);

    assertEquals(result.get().getUnp(), unp);
  }

  @Test
  public void findOrganizationByIdTest(){
    long organizationId = 1L;

    Optional<Organization> result  = organizationRepository.findOrganizationById(organizationId);

    assertEquals(result.get().getId(), organizationId);
  }

  @Test
  public void getOrganizationByIdTest(){
    long organizationId = 1L;

    Organization result  = organizationRepository.getOrganizationById(organizationId);

    assertEquals(result.getId(), organizationId);
  }

  @Test
  public void getByUnpTest(){
    int unp = 111111111;

    Organization result  = organizationRepository.getByUnp(unp);

    assertEquals(result.getUnp(), unp);
  }

  @Test
  public void findOrganizationsByUsersIsNullTest(){

    List<Organization>  organizations  = organizationRepository.findOrganizationsByUsersIsNull();

    assertThat(organizations).hasSize(1);
  }

}
