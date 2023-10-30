import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.teachmeskills.model.Organization;
import org.teachmeskills.repository.OrganizationRepository;
import org.teachmeskills.service.OrganizationService;

import java.util.ArrayList;
import java.util.List;
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

  @Test
  public void OrganizationFindByUNPTest() {

    int unp = 222222222;
    Organization created = new Organization(1, unp,
        "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
        "г. Минск",null,null,null,null);

    given(organizationService.findOrganizationByUnp(unp)).willReturn(created);
    Organization expected = organizationService.findOrganizationByUnp(unp);

    assertEquals(expected, created);
  }

//  @Test
//  public void createOrganizationTest() {
//
//    CreateOrganizationDto createOrganizationDto = new CreateOrganizationDto();
//    createOrganizationDto.setUnp(222222222);
//    createOrganizationDto.setFullName("Общество с ограниченной ответственностью 'Ромашка'");
//    createOrganizationDto.setShortName("ООО 'Ромашка'");
//    createOrganizationDto.setLegalAddress("г. Минск");
//    createOrganizationDto.setActualAddress("г. Минск");
//
//    Organization created = new Organization(2, 222222222,
//        "Общество с ограниченной ответственностью 'Ромашка'",  "ООО 'Ромашка'",
//        "г. Минск","г. Минск",null,null,null,null);
//
//    given(organizationService.createOrganization(createOrganizationDto)).willReturn(created);
//    Organization expected = organizationService.createOrganization(createOrganizationDto);
//
//    assertEquals(expected, created);
//  }

  @Test
  public void findOrganizationsByUsersIsNullTest() {

    List<Organization> organizationList = new ArrayList<>();
    organizationList.add(new Organization (2, 222222222,"Общество с ограниченной ответственностью 'Ромашка'","ООО 'Ромашка'", " г. Минск",
        "г. Минск",null,null,null,null));
    organizationList.add(new Organization (3, 333333333,"Общество с ограниченной ответственностью 'Роза'", "ООО 'Роза'", "г. Минск",
        "г. Минск", null,null,null,null));
    organizationList.add(new Organization (4,444444444 ,"Общество с ограниченной ответственностью 'Пион'", "ООО 'Пион'", " г. Минск",
        "г. Минск",null,null,null,null));
    organizationList.add(new Organization (5,555555555, "Общество с ограниченной ответственностью 'МТЗ'", "ООО 'МТЗ'", " г. Минск",
        "г. Минск",null,null,null,null));
    organizationList.add(new Organization (6,666666666, "Общество с ограниченной ответственностью 'Geely'","ООО 'Geely'", " г. Минск",
        "г. Минск", null,null,null,null ));

    given(organizationService.findOrganizationsByUsersIsNull()).willReturn(organizationList);
    List<Organization> expected = organizationService.findOrganizationsByUsersIsNull();

    assertEquals(expected, organizationList);
  }

  @Test
  public void findPaginatedAllOrganizationsTest() {

    List<Organization> organizationList = new ArrayList<>();
    organizationList.add(new Organization (2, 222222222,"Общество с ограниченной ответственностью 'Ромашка'","ООО 'Ромашка'", " г. Минск",
        "г. Минск",null,null,null,null));
    organizationList.add(new Organization (3, 333333333,"Общество с ограниченной ответственностью 'Роза'", "ООО 'Роза'", "г. Минск",
        "г. Минск", null,null,null,null));
    organizationList.add(new Organization (4,444444444 ,"Общество с ограниченной ответственностью 'Пион'", "ООО 'Пион'", " г. Минск",
        "г. Минск",null,null,null,null));
    organizationList.add(new Organization (5,555555555, "Общество с ограниченной ответственностью 'МТЗ'", "ООО 'МТЗ'", " г. Минск",
        "г. Минск",null,null,null,null));
    organizationList.add(new Organization (6,666666666, "Общество с ограниченной ответственностью 'Geely'","ООО 'Geely'", " г. Минск",
        "г. Минск", null,null,null,null ));

    Page<Organization> paginated = organizationRepository.findAll(PageRequest.of(2, 3));
    Page<Organization> paginatedUsers = organizationService.findPaginatedAllOrganizations(2, 3);

    assertEquals(paginatedUsers, paginated);
  }
}