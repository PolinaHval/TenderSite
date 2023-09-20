package org.teachmeskills.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.teachmeskills.session.AuthContext;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
  public AuthContext authContext() {
    return new AuthContext();
  }

}
