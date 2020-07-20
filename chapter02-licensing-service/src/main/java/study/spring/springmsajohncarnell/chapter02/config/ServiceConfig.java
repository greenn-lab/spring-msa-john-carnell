package study.spring.springmsajohncarnell.chapter02.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
  
  @Value("${example.property:Hello}")
  @Getter
  private String exampleProperty;

}
