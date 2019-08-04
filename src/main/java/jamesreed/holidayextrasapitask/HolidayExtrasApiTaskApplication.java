package jamesreed.holidayextrasapitask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan({"jamesreed.holidayextrasapitask.user"})
public class HolidayExtrasApiTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidayExtrasApiTaskApplication.class, args);
	}

}
