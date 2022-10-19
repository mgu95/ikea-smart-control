package pl.mgu95.ikeasmartcontrol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.mgu95.ikeasmartcontrol.data.model.Client;
import pl.mgu95.ikeasmartcontrol.data.repositories.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class IkeaSmartControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(IkeaSmartControlApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx, UserRepository repository) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}

}
