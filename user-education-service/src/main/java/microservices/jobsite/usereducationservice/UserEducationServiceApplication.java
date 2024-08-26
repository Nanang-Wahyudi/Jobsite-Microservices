package microservices.jobsite.usereducationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserEducationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserEducationServiceApplication.class, args);
	}

}
