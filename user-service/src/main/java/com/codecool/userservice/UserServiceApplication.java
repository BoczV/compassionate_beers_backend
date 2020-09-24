package com.codecool.userservice;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.BeerRepository;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class UserServiceApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BeerRepository beerRepository;

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
			String encodePassword = passwordEncoder.encode("ugyi");
			User user = User.builder().userName("Isti").password(encodePassword).email("isti@gmail.com").build();
			user.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
			System.out.println(user);
			userRepository.save(user);

			Beer beer = Beer.builder().abv
					((float) 1.5)
					.id(1L).name("Buzz")
					.first_brewed("10-2007").image_url("valami")
					.username("Isti").build();
			beerRepository.save(beer);

		};

	}

}
