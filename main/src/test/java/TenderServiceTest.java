import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.repository.TenderRepository;
import org.teachmeskills.service.OrganizationService;
import org.teachmeskills.service.TenderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TenderServiceTest {

  @InjectMocks
  private TenderService tenderService;

  @Mock
  private TenderRepository tenderRepository;


  @Test
  public void getTenderByIdTest() {

  int id = 1;
  Tender created = new Tender(1,"Яблоки", "Яблоки", "BYN", 2,"кг",
      5,10,"отсрочка", "отсрочка",new Organization(1, 222222222,
      "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
      "г. Минск",null,null,null,null),null,null);

  given(tenderService.getTenderById(id)).willReturn(created);
  Tender expected = tenderService.getTenderById(id);

  assertEquals(expected,created);
  }

//  @Test
//  public void getListTendersTest() {
//    long organizationId=1;
//    Organization organization = new Organization(organizationId, 222222222,
//        "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
//        "г. Минск",null,null,null,null);
//
//    List<Tender> tenders = new ArrayList<>();
//    tenders.add(new Tender (1,"Яблоки", "Яблоки", "BYN", 2,"кг",
//        5,10,"отсрочка", "отсрочка",organization,null,null));
//    tenders.add(new Tender (2,"Груши", "Груши", "BYN", 10,"кг",
//        5,50,"отсрочка", "отсрочка",organization,null,null));
//    tenders.add(new Tender (3,"Сливы", "Сливы", "BYN", 3,"кг",
//        3,9,"отсрочка", "отсрочка",organization,null,null));
//    tenders.add(new Tender (4,"Арбуз", "Арбуз", "BYN", 2,"кг",
//        5,10,"отсрочка", "отсрочка",organization,null,null));
//    tenders.add(new Tender (5,"Виноград", "Винноград", "BYN", 2,"кг",
//        5,10,"отсрочка", "отсрочка",organization,null,null));
//
//    given(tenderService.getListTenders(organizationId)).willReturn(tenders);
//    List<Tender> expected = tenderService.getListTenders(organizationId);
//
//    assertEquals(expected, tenders);
//  }

  @Test
  public void indTenderByIdTest(){
    long organizationId=1;
    Organization organization = new Organization(organizationId, 222222222,
        "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
        "г. Минск",null,null,null,null);

    List<Tender> tenders = new ArrayList<>();
    tenders.add(new Tender (1,"Яблоки", "Яблоки", "BYN", 2,"кг",
        5,10,"отсрочка", "отсрочка",organization,null,null));
    tenders.add(new Tender (2,"Груши", "Груши", "BYN", 10,"кг",
        5,50,"отсрочка", "отсрочка",organization,null,null));
    tenders.add(new Tender (3,"Сливы", "Сливы", "BYN", 3,"кг",
        3,9,"отсрочка", "отсрочка",organization,null,null));
    tenders.add(new Tender (4,"Арбуз", "Арбуз", "BYN", 2,"кг",
        5,10,"отсрочка", "отсрочка",organization,null,null));
    tenders.add(new Tender (5,"Виноград", "Винноград", "BYN", 2,"кг",
        5,10,"отсрочка", "отсрочка",organization,null,null));

    Page<Tender> paginated = tenderRepository.findAll(PageRequest.of(2, 3));
    Page<Tender> paginatedUsers = tenderService.findPaginatedAllTenders(2, 3);

    assertEquals(paginatedUsers, paginated);
  }

  @Test
  public void findTenderByIdTest() {

    long id = 1;
    Tender tender = new Tender(1,"Яблоки", "Яблоки", "BYN", 2,"кг",
        5,10,"отсрочка", "отсрочка",new Organization(1, 222222222,
        "Общество с ограниченной ответсвенностью 'Пример'","ООО 'Пример'","г. Минск",
        "г. Минск",null,null,null,null),null,null);

    final Optional<Tender> expectedTender = Optional.of(tender);

    given(tenderService.findTenderById(tender.getId())).willReturn(expectedTender);
    Optional<Tender> returnedTender =tenderService.findTenderById(tender.getId());

    assertEquals(returnedTender, expectedTender);
  }
}
