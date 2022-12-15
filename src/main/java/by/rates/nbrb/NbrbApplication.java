package by.rates.nbrb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NbrbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbrbApplication.class, args);
	}

}
