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
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.config.service.SpringSecurityUserService;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.User;
import org.teachmeskills.service.HashPassword;
import org.teachmeskills.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UsersOrganizationController.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = UsersOrganizationController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersOrganizationControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private WebApplicationContext applicationContext;
  @MockBean
  private UserService userService;
  @MockBean
  private Role role;
  @MockBean
  private Organization organization;
  @MockBean
  private HashPassword hashPassword;

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
  public void getAllUsersTests() throws Exception {

    List<User> users = new ArrayList<>();
    users.add(new User(1, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(2, "Polya", hashPassword.hashingPassword("123"), "Polina", "Petrova",
        "Ivanovna", "test1@mail.ru", "80291111111", "Директор", organization, role));

    given(userService.getUsers(1)).willReturn(users);

    mockMvc.perform(MockMvcRequestBuilders
            .get("/users"))
        .andExpect(status().isOk())
        .andExpect(view().name("users"))
        .andExpect(model().attributeExists("users"))
        .andExpect(content().string(containsString("<a class=\"btn btn-primary m-4\" href=\"/addUser\" role=\"button\">Добавить пользователя</a>")))
        .andExpect(content().string(containsString( "<th>Логин</th>")))
        .andExpect(content().string(containsString( "<th>Фамилия</th>")))
        .andExpect(content().string(containsString( "<th>Имя</th>")))
        .andExpect(content().string(containsString( "<th>Отчество</th>")))
        .andExpect(content().string(containsString( "<th>Адрес почты</th>")))
        .andExpect(content().string(containsString( "<th>Действия</th>")));
  }
  @Test
  @WithUserDetails(value = "Alina", userDetailsServiceBeanName = "mockUserService")
  public void deleteUser() throws Exception {
    User user = new User(2, "Polya", hashPassword.hashingPassword("123"), "Polina", "Petrova",
        "Ivanovna", "test1@mail.ru", "80291111111", "Директор", organization, role);

    BDDMockito.given(userService.getUserById(2)).willReturn(user);
    BDDMockito.doNothing().when(userService).deleteUser(user);

    mockMvc.perform(MockMvcRequestBuilders
            .delete("/users/2")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
        .andExpect(status().isAccepted())
        .andExpect(redirectedUrl("/users"));
  }
}
