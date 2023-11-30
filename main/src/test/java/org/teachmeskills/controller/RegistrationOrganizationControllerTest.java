package org.teachmeskills.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.teachmeskills.controller.RegistrationOrganizationController;
import org.teachmeskills.dto.CreateOrganizationDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.service.OrganizationService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@WebMvcTest(RegistrationOrganizationController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = RegistrationOrganizationController.class)
public class RegistrationOrganizationControllerTest {


  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OrganizationService organizationService;

  @MockBean
  private Organization organization;

  @Test
  public void testOrganizationRegistrationGet() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
            .get("/regOrganization"))
        .andExpect(status().isOk())
        .andExpect(view().name("regOrganization"))
        .andExpect(model().attributeExists("createOrganizationDto"));
  }

  @Test
  public void testOrganizationRegistrationPost() throws Exception {

    CreateOrganizationDto createOrganizationDto = new CreateOrganizationDto();
    createOrganizationDto.setUnp(222222222);
    createOrganizationDto.setFullName("Общество с ограниченной ответственностью 'Ромашка'");
    createOrganizationDto.setShortName("ООО 'Ромашка");
    createOrganizationDto.setLegalAddress("г. Минск");
    createOrganizationDto.setActualAddress("г. Минск");

    BDDMockito.given(organization.getId()).willReturn(1L);
    BDDMockito.given(organizationService.findOrganizationByUnp(createOrganizationDto.getUnp())).willReturn(organization);


    mockMvc.perform(MockMvcRequestBuilders
            .post("/regOrganization")
            .param("unp", "222222222")
            .param("fullName", "fullName")
            .param("shortName", "shortName")
            .param("legalAddress", "legalAddress")
            .param("actualAddress", "actualAddress")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        )
        .andExpect(redirectedUrl("/registration/1"));
  }
}







