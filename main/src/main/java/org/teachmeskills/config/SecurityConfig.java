package org.teachmeskills.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {


  @Bean
  public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((requests) -> requests
            .antMatchers( "/","/login", "/app","/regOrganization", "/registration/**").permitAll()
//            .antMatchers("/mainUser/").hasAnyRole("MAINUSER")
//            .antMatchers("/user/").hasAnyRole("USER")
            .anyRequest().authenticated()
        )
        .formLogin().loginPage("/login")
        .defaultSuccessUrl("/homePage")
        .permitAll()
        .and()
        .logout(LogoutConfigurer::permitAll);

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


//  @Bean
//  @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
//  public AuthContext authContext() {
//    return new AuthContext();
//  }

}
