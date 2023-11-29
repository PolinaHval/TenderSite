package tenderTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.config.service.SpringSecurityUserService;
import org.teachmeskills.controller.VictoryController;
import org.teachmeskills.facade.TenderFacade;
import org.teachmeskills.facade.VictoryFacade;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.Tender;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


@ExtendWith(SpringExtension.class)
@WebMvcTest(VictoryController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = VictoryController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VictoryTests {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private VictoryFacade victoryFacade;

  @MockBean
  private TenderFacade tenderFacade;
  @MockBean
  private Organization organization;
  @MockBean
  private Role role;

  @MockBean
  private MyUser myUser;

  @MockBean(name = "mockUserService")
  private SpringSecurityUserService springSecurityUserService;

  @BeforeAll
  public void setup(){
    MyUser myUser1 = new MyUser("Alina",  "123", List.of(new SimpleGrantedAuthority("ROLE_" + "mainUser")),
        organization, "Alina", "Иванова", "Иванована","test@mail.ru","Директор","80291111111",1,role);

    given(springSecurityUserService.loadUserByUsername("Alina")).willReturn(myUser1);
  }
  @Test
  @WithUserDetails(value = "Alina", userDetailsServiceBeanName = "mockUserService")
  public void testCreateVictoryPost() throws Exception {
    final int tenderId = 1;
    final Tender tender = Tender.builder()
        .id(1)
        .subject("Яблоки")
        .shortDescription("Яблоки 2 кг")
        .valuta("Belarusian ruble (BYN)")
        .amount(3)
        .unitOfMeasurement("кг")
        .unitPrice(5)
        .totalCost(15)
        .termsOfPayment("предопалата")
        .deliveryConditions("30 дней")
        .organizationTenders(organization)
        .build();

    Application application = new Application(1, 5,15,organization, tender);

    BDDMockito.given(tenderFacade.getTender(1)).willReturn(tender);
    BDDMockito.given(victoryFacade.getApplication(1)).willReturn(application);


    mockMvc.perform(MockMvcRequestBuilders
            .post("/victory/1/1"))
        .andExpect(redirectedUrl("/tender/1"));
  }
}

