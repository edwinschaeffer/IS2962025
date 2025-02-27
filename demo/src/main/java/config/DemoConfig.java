package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.controller")
public class DemoConfig {
	
	
	@Bean
	public String getString() {
		System.out.println("getString bean instantiated");		
		return "getString";
	}
	
	@Bean
	public int getNumberofCharactersInString(String myString) {
		System.out.println("The number of characters in myString is: " + myString.length());
		return myString.length();
	}

}
