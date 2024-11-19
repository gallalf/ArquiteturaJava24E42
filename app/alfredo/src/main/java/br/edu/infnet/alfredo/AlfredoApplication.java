package br.edu.infnet.alfredo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfredoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfredoApplication.class, args);
	}

}
