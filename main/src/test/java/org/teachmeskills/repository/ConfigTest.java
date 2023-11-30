package org.teachmeskills.repository;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.transaction.AfterTransaction;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class ConfigTest {

  @ClassRule
  @Container
  public static PostgreSQLContainer container = (PostgreSQLContainer) new PostgreSQLContainer("postgres:13.4")
      .withUsername("postgres")
      .withPassword("postgres")
      .withDatabaseName("tests")
      .withInitScript("init.sql")
      .withExposedPorts(5432);

  @BeforeAll
  public static void setUp() {
    container.withReuse(true);
    container.start();
  }

  @DynamicPropertySource
  public static void overrideProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.username", container::getUsername);
    registry.add("spring.datasource.password", container::getPassword);
  }

  @AfterTransaction
  public static void tearDown() {
    container.stop();
  }
}
