package study.spring.springmsajohncarnell.chapter06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class  Chapter06ZuulServerApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(Chapter06ZuulServerApplication.class, args);
  }
  
}
