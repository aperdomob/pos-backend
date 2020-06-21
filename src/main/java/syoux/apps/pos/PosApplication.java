package syoux.apps.pos;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedMethods(
								RequestMethod.GET.toString(),
								RequestMethod.POST.toString(),
								RequestMethod.PUT.toString(),
								RequestMethod.DELETE.toString(),
								RequestMethod.PATCH.toString())
						.allowedOrigins("http://localhost:4200");
			}
		};
	}

}
