package tenderTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.teachmeskills.controller.TenderController;
import org.teachmeskills.facade.TenderFacade;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TenderController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = TenderController.class)
public class TenderControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private TenderFacade tenderFacade;
  @MockBean
  private Organization organization;
  @Test
  public void test() throws Exception {
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

    List<Application> applications = new ArrayList<>();
    applications.add(new Application(1, 5,15,organization, tender));

    BDDMockito.given(tenderFacade.getTender(1)).willReturn(tender);
    BDDMockito.given(tenderFacade.getApplications(1)).willReturn(applications);
    BDDMockito.given(tenderFacade.getCountApplications(tender)).willReturn(1);

    mockMvc.perform(MockMvcRequestBuilders
            .get("/tender/1"))
        .andExpect(status().isOk());
  }

}
