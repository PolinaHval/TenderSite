package tenderTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.teachmeskills.model.Role;
import org.teachmeskills.service.RoleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

  @InjectMocks
  private RoleService roleService;


  @Test
  public void getRoleByNameTest() {

    String roleName = "user";
    Role role = new Role(3,"user");

    given(roleService.getRoleByName(roleName)).willReturn(role);
    Role expected = roleService.getRoleByName(roleName);

    assertEquals(expected, role);
  }
}