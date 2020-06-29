package study.spring.msa;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
@EnableCircuitBreaker
@EnableEurekaClient
public class SpringMSAApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(SpringMSAApplication.class, args);
  }
  
  @HystrixCommand(threadPoolKey = "helloThreadPool")
  public String helloRemoteServiceCall(String firstName, String lastName) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> entity = restTemplate.getForEntity(
        "http://logical-service-id/name/{firstName}/{lastName}",
        String.class,
        firstName, lastName
    );
    
    return entity.getBody();
  }
  
  @GetMapping("/{firstName}/{lastName}")
  public String hello(@PathVariable String firstName,
                      @PathVariable String lastName) {
    return helloRemoteServiceCall(firstName, lastName);
  }
}
