package demo.practice.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import demo.practice.springbootmvc.config.ApplicationConfiguration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(ApplicationConfiguration.class)
public class SpringBootMvcApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}
}
