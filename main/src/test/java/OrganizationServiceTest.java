import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.teachmeskills.model.Organization;
import org.teachmeskills.repository.OrganizationRepository;
import org.teachmeskills.service.OrganizationService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrganizationServiceTest {

  @InjectMocks
  private OrganizationService organizationService;

  @Mock
  private OrganizationRepository organizationRepository;

  @Test
  public void OrganizationByIdTest() {

    long id = 1;
    Organization created = new Organization(id, 222222222,
        "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
        "г. Минск",null,null,null,null);

    given(organizationService.getOrganizationById(id)).willReturn(created);
    Organization expected = organizationService.getOrganizationById(id);

    assertEquals(expected, created);
  }


  @Test
  public void OrganizationFindByIdTest() {

    long id = 1;
    Organization organization = new Organization(id, 222222222,
        "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
        "г. Минск",null,null,null,null);
    final Optional<Organization> expectedOrganization = Optional.of(organization);

    given(organizationService.findOrganizationById(organization.getId())).willReturn(expectedOrganization);
    Optional<Organization> returnedOrganization = organizationService.findOrganizationById(organization.getId());

    assertEquals(returnedOrganization, expectedOrganization);
  }
}