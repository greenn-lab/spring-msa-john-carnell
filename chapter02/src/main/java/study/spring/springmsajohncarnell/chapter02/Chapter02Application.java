package study.spring.springmsajohncarnell.chapter02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class Chapter02Application {
  
  public static void main(String[] args) {
    SpringApplication.run(Chapter02Application.class, args);
  }
  
}
