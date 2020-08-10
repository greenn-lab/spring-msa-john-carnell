package study.spring.springmsajohncarnell.chapter07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@RestController
public class Chapter07Application {
  
  @GetMapping(path = "/user", produces = "application/json")
  public OAuth2Authentication user(OAuth2Authentication user) {
    return user;
  }
  
  public static void main(String[] args) {
    SpringApplication.run(Chapter07Application.class, args);
  }
  
}
