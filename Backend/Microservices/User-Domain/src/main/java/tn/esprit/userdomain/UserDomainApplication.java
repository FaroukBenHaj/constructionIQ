package tn.esprit.userdomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDomainApplication.class, args);
	}

}
