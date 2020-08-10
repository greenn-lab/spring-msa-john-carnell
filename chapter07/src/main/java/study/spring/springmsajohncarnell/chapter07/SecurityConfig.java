package study.spring.springmsajohncarnell.chapter07;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /*@formatter:off*/
    auth
        .inMemoryAuthentication()
        .withUser("ohhh")
          .password(passwordEncoder().encode("ohhh"))
          .roles("USER")
          .and()
        .withUser("imsb")
          .password(passwordEncoder().encode("imsb"))
          .roles("USER", "ADMIN")
        .and()
    ;
    /*@formatter:on*/
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic()
    ;
  }
  
  @Override
  public void configure(WebSecurity web) {
    web
        .ignoring()
        .mvcMatchers("/error")
    ;
  }
  
  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }
  
  @Bean
  public UserDetailsService userDetailsService() {
    return super.userDetailsService();
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
  
}
