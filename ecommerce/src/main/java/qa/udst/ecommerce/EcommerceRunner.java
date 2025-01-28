package qa.udst.ecommerce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import qa.udst.ecommerce.model.*;
@Component
@Slf4j

public class EcommerceRunner implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception {
        log.info("Testing Lombok-refactored code...");
        System.out.println("****Test");
        // Create example objects with correct constructor parameters
        PhysicalProduct laptop = new PhysicalProduct("Laptop", 1500.0, 2.5);
        DigitalProduct ebook = new DigitalProduct("E-Book", 20.0, "https://example.com/download");
        log.debug("Created new products: {} and {}", laptop.getName(), ebook.getName());

        // Test getters
        log.debug("Laptop Name: {}", laptop.getName());
        log.debug("E-Book Price: ${}", ebook.getPrice());

        // Test setters
        laptop.setPrice(1400.0);
        log.info("Updated Laptop Price to: ${}", laptop.getPrice());

        // Test toString
        log.debug("Laptop Details: {}", laptop);

        // Test equals
        PhysicalProduct anotherLaptop = new PhysicalProduct("Laptop", 1400.0, 2.5);
        log.debug("Laptops equality check: {}", laptop.equals(anotherLaptop));

        log.info("Ecommerce application testing completed successfully");
    }
}
