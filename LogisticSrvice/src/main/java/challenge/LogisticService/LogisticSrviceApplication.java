package challenge.LogisticService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class LogisticSrviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticSrviceApplication.class, args);
	}

}
