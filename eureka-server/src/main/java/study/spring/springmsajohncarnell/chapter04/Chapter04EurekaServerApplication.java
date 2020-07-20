package study.spring.springmsajohncarnell.chapter04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Chapter04EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04EurekaServerApplication.class, args);
	}

}
