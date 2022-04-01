package br.com.example.userapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import br.com.example.userapi.domain.User;
import br.com.example.userapi.repositories.UserRepository;

@EnableEurekaClient
@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "William Douglas", "william@email.com", "123", 20.0),
				new User(null, "Oliveira Santos", "oliveira@email.com", "456", 25.0)));
	}

}
