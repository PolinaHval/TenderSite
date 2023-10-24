import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.teachmeskills.dto.CreateUserDto;

import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.User;
import org.teachmeskills.repository.UserRepository;
import org.teachmeskills.service.HashPassword;
import org.teachmeskills.service.OrganizationService;
import org.teachmeskills.service.RoleService;
import org.teachmeskills.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private HashPassword hashPassword;

  @Mock
  private UserRepository userRepository;

  @Mock
  private OrganizationService organizationService;

  @Mock
  private RoleService roleService;

  @Test
  public void getUserByUserNameTest() {
    Organization organization = organizationService.getOrganizationById(1);
    Role role = roleService.getRoleByName("user");

    String userName = "Alina";
    User user = new User("Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role);

    given(userService.getUserLogin(userName)).willReturn(user);
    User expected = userService.getUserLogin(userName);

    assertEquals(expected, user);
  }

  @Test
  public void getUserByUserIdTest() {
    Organization organization = organizationService.getOrganizationById(1);
    Role role = roleService.getRoleByName("user");

    long id = 1;
    User user = new User(id, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role);

    given(userService.getUserById(id)).willReturn(user);
    User expected = userService.getUserById(id);

    assertEquals(expected, user);
  }

  @Test
  public void createUserTest() {
    Organization organization = organizationService.getOrganizationById(1);
    Role role = roleService.getRoleByName("user");

    CreateUserDto userDto = new CreateUserDto();
    userDto.setUsername("Alina");
    userDto.setPassword(hashPassword.hashingPassword("123"));
    userDto.setName("Alina");
    userDto.setLastName("Иванова");
    userDto.setPatronymic("Иванована");
    userDto.setName("test@mail.ru");
    userDto.setPhone("80291111111");
    userDto.setJobTitle("Директор");
    User created = new User(1, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role);

    given(userService.createUser(userDto, organization)).willReturn(created);
    User expected = userService.createUser(userDto, organization);

    assertEquals(expected, created);
  }

  @Test
  public void findUserByUserNameTest() {
    Organization organization = organizationService.getOrganizationById(1);
    Role role = roleService.getRoleByName("user");

    final User user = new User(1, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role);
    final Optional<User> expectedUser = Optional.of(user);

    given(userService.findUser(user.getUsername())).willReturn(expectedUser);
    Optional<User> returnedUser = userService.findUser(user.getUsername());

    assertEquals(returnedUser, expectedUser);
  }

  @Test
  public void findPaginatedAllUsers() {
    Organization organization = organizationService.getOrganizationById(1);
    Role role = roleService.getRoleByName("user");

    List<User> users = new ArrayList<>();
    users.add(new User(1, "Alina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(2, "Polya", hashPassword.hashingPassword("123"), "Polina", "Petrova",
        "Ivanovna", "test1@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(3, "Alin", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test2@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(4, "lina", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test3@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(5, "Mikhail", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test4@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(6, "Roma", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test5@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(7, "Olga", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test6@mail.ru", "80291111111", "Директор", organization, role));
    users.add(new User(8, "Vova", hashPassword.hashingPassword("123"), "Alina", " Иванова",
        "Иванована", "test7@mail.ru", "80291111111", "Директор", organization, role));

    Page<User> paginated = userRepository.findAll(PageRequest.of(2, 3));
    Page<User> paginatedUsers = userService.findPaginatedAllUsers(2, 3);

    assertEquals(paginatedUsers, paginated);
  }
}

