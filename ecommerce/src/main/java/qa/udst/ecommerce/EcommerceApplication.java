package qa.udst.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import qa.udst.ecommerce.model.*;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
	SpringApplication.run(EcommerceApplication.class, args);
	System.out.println("Spring Boot Application Started Successfully!");
	}
}
