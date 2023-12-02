package org.teachmeskills.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Role;
import org.teachmeskills.model.User;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryIntegrationTest extends ConfigTest{

  @Autowired
  private UserRepository userRepository;

  @Test
  public void saveUserTest() {
    User user = new User("Olya", "123", "Alina", " Иванова",
        "Иванована", "test@mail.ru", "80291111111", "Директор", new Organization(2,
        222222222,"Общество с ограниченной ответственностью 'Ромашка'","ООО 'Ромашка'",
        " г. Минск", "г. Минск",null,null,null,null),
        new Role(1,"user"));

    userRepository.save(user);

    Assert.assertNotNull(userRepository.getUserByUsername(user.getUsername()));
  }

  @Test
  public void findUserByIdTest (){
    long id = 1L;

    User result  = userRepository.findUserById(id);

    assertEquals(result.getId(), id);
  }

  @Test
  public void getUserByUsernameTest (){
    String username = "Polina";

    User result  = userRepository.getUserByUsername(username);

    assertEquals(result.getUsername(), username);
  }

  @Test
  public void findByEmailTest (){
    String email = "alina@tander.ru";

    Optional<User> result  = userRepository.findByEmail(email);

    assertEquals(result.get().getEmail(), email);
  }

  @Test
  public void findByUsernameTest (){
    String username = "Alina";

    Optional<User> result  = userRepository.findByUsername(username);

    assertEquals(result.get().getUsername(), username);
  }

}
