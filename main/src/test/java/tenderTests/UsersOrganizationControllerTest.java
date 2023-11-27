package tenderTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.teachmeskills.config.service.MyUser;
import org.teachmeskills.config.service.SpringSecurityUserService;
import org.teachmeskills.controller.UsersOrganizationController;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.User;
import org.teachmeskills.service.HashPassword;
import org.teachmeskills.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
  @MockBean
  private UserDetailsService userDetailsService;
  @MockBean
  private SpringSecurityUserService springSecurityUserService;

  @Test
  @WithMockUser(value = "Alina", password = "123")
  public void test() throws Exception {
        MyUser myUser1 = new MyUser ("Alina",  hashPassword.hashingPassword("123"), List.of(new SimpleGrantedAuthority("ROLE_" + "mainUser")),
        organization, "Alina", "Иванова", "Иванована","test@mail.ru","Директор","80291111111",1,role);
//
//    given(springSecurityUserService.loadUserByUsername("Alina")).willReturn(myUser1);


    List<User> users = new ArrayList<>();
    users.add(new User(1, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(2, "Polya", hashPassword.hashingPassword("123"), "Polina", "Petrova",
        "Ivanovna", "test1@mail.ru", "80291111111", "Директор", organization, role));

    given(userService.getUsers(1)).willReturn(users);

    mockMvc.perform(MockMvcRequestBuilders
            .get("/users"))
        .andExpect(status().isOk());
  }
}



//    MyUser myUser1 = new MyUser ("Alina",  hashPassword.hashingPassword("123"), List.of(new SimpleGrantedAuthority("ROLE_" + "mainUser")),
//        organization, "Alina", "Иванова", "Иванована","test@mail.ru","Директор","80291111111",1,role);

//        User user1 = new User (1, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
//            "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role);
