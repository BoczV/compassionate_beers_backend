package com.codecool.userservice;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class UserServiceApplication {

	@Autowired
	private UserRepository userRepository;

	private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/profile/**")).build();
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init(){
		return args -> {
			Set<Beer> beers = new HashSet<>();
			String encodePassword = passwordEncoder.encode("ugyi");
			User user = User.builder().userName("Isti").password(encodePassword).email("isti@gmail.com").build();
			beers.add(new Beer(1L, "daf", "name", "1999", (float) 1.5, user));
			user.setBeers(beers);
			user.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
			System.out.println(user);
			userRepository.save(user);
		};

	}

}
