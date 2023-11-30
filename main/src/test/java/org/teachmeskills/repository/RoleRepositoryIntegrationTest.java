package org.teachmeskills.repository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.teachmeskills.model.Role;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;



@ExtendWith(SpringExtension.class)
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RoleRepositoryIntegrationTest extends ConfigTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void getRoleByRoleNameTest() {
        Role expected = new Role(2L, "user");
        Role result = roleRepository.getRoleByName("user");

        assertEquals(result, expected);
    }
}
