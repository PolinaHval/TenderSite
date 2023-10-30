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
import org.teachmeskills.service.OrganizationService;
import org.teachmeskills.service.TenderService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

  @InjectMocks
  private ApplicationService applicationService;

  @Test
  public void getApplicationByIdTest(){
    Organization organization = new Organization (3, 333333333,"Общество с ограниченной ответственностью 'Роза'", "ООО 'Роза'", "г. Минск",
        "г. Минск", null,null,null,null);
    Tender tender = new Tender(1,"Яблоки", "Яблоки", "BYN", 2,"кг",
      5,10,"отсрочка", "отсрочка",new Organization(1, 222222222,
      "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
      "г. Минск",null,null,null,null),null,null);

    int id = 1;
    Application created = new Application(1,2,4,organization,tender);

    given(applicationService.getApplicationById(id)).willReturn(created);
    Application expected = applicationService.getApplicationById(id);

    assertEquals(expected,created);
  }
}



