package org.teachmeskills.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.teachmeskills.validation.EmailValidator;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;


@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/registration").setViewName("registration");
    registry.addViewController("/regOrganization").setViewName("regOrganization");
    registry.addViewController("/homePage").setViewName("homePage");
    registry.addViewController("/myTenders").setViewName("myTenders");
    registry.addViewController("/createTender").setViewName("createTender");
    registry.addViewController("/personal").setViewName("personal");
    registry.addViewController("/search").setViewName("search");
    registry.addViewController("/organization").setViewName("organization");
    registry.addViewController("/users").setViewName("users");
    registry.addViewController("/addUser").setViewName("addUser");
    registry.addViewController("/tender").setViewName("tender");
    registry.addViewController("/createApplication").setViewName("createApplication");
    registry.addViewController("/myApplications").setViewName("myApplications");
    registry.addViewController("/considerApplications").setViewName("considerApplications");
    registry.addViewController("/victory").setViewName("victory");
    registry.addViewController("/app").setViewName("app");
    registry.addViewController("/organizationExists").setViewName("organizationExists");
    registry.addViewController("/userExists").setViewName("userExists");
    registry.addViewController("/userNameExists").setViewName("userNameExists");
    registry.addViewController("/preApplications").setViewName("preApplications");
  }

  @Bean
  public IDialect conditionalCommentDialect() {
    return new Java8TimeDialect();
  }

  @Bean
  public EmailValidator usernameValidator() {
    return new EmailValidator();
  }

}
