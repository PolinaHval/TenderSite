package org.teachmeskills.controller;

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
import org.teachmeskills.facade.TenderFacade;
import org.teachmeskills.model.Application;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.Tender;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TenderController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = TenderController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TenderControllerTest {
  @Autowired
  private MockMvc mockMvc;
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
  public void shouldReturnOkRequestWhenIdValid() throws Exception {
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
            .get("/tender/{tenderId}", tenderId))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("<h2> № <span>1</span></h2>")))
        .andExpect(content().string(containsString("<h3><span>Яблоки</span></h3>")))
        .andExpect(content().string(containsString("<td>Краткое описание</td>")))
        .andExpect(content().string(containsString("<span>Яблоки 2 кг</span>")))
        .andExpect(content().string(containsString("<td>Организатор</td>")))
        .andExpect(content().string(containsString("<td>Единицы измерения</td>")))
        .andExpect(content().string(containsString("<span>кг</span>")))
        .andExpect(content().string(containsString("<td>Количество единиц</td>")))
        .andExpect(content().string(containsString("<span>3</span>")))
        .andExpect(content().string(containsString("<td>Цена за единицу</td>")))
        .andExpect(content().string(containsString("<span>5</span>")))
        .andExpect(content().string(containsString("<td>Общая стоимость закупки</td>")))
        .andExpect(content().string(containsString("<span>15</span>")))
        .andExpect(content().string(containsString("<td>Вид валюты</td>")))
        .andExpect(content().string(containsString("<span>Belarusian ruble (BYN)</span>")))
        .andExpect(content().string(containsString(" <td>Условия дставки</td>")))
        .andExpect(content().string(containsString("<span>30 дней</span>")))
        .andExpect(content().string(containsString("<td>Условия оплаты</td>")))
        .andExpect(content().string(containsString("<span>предопалата</span>")));
  }

  @Test
  @WithUserDetails(value = "Alina", userDetailsServiceBeanName = "mockUserService")
  public void shouldReturnBadRequestWhenIdInvalid() throws Exception {
    final String tenderId = "invalid";
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
            .get("/tender/{tenderId}", tenderId))
        .andExpect(status().isBadRequest());
  }
}
