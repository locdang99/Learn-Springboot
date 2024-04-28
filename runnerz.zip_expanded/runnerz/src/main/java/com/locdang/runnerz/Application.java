package com.locdang.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.locdang.runnerz.run.Location;
import com.locdang.runnerz.run.Run;
import com.locdang.runnerz.user.User;
import com.locdang.runnerz.user.UserHttpClient;
import com.locdang.runnerz.user.UserRestClient;
import com.locdang.runnerz.run.JdbcClientRunRepository;

//import foo.bar.WelcomeMessage;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//		var welcomMsg = new WelcomeMessage();
//		System.out.println(welcomMsg.getWelcomeMessage());

		//
//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		WelcomeMessage welcomMsg = (WelcomeMessage) context.getBean("welcomeMessage");
//		System.out.println(welcomMsg);

		SpringApplication.run(Application.class, args);
		log.info("Application started successfully with Roger(Loc) Dang!");
	}

//	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
//		return args -> {
//			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5,
//					Location.OUTDOOR);	
//			runRepository.create(run);
//		};
//	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHttpClient.class);
	}

	@Bean
	CommandLineRunner runner(UserHttpClient client) {
		return args -> {
			List<User> users = client.findAll();
			System.out.println(users.get(0));

			User user = client.findById(4);
			System.out.println(user);
		};
	}

}
