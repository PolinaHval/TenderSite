package tenderTests;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.teachmeskills.model.Role;
import org.teachmeskills.repository.RoleRepository;


import static org.junit.Assert.assertEquals;
@SpringBootTest(classes = RoleRepository.class)
public class RoleIntegrationTest extends ConfigTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void getRoleByRoleNameTest() {
        Role expected = new Role(2L, "user");
        Role result = roleRepository.getRoleByName("user");

        assertEquals(result, expected);
    }
}
