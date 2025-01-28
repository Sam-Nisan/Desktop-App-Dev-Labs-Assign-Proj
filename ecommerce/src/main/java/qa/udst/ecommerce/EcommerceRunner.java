package qa.udst.ecommerce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import qa.udst.ecommerce.model.*;
import qa.udst.ecommerce.services.ProductServices;

@Component
@Slf4j
public class EcommerceRunner implements CommandLineRunner {
    
    @Autowired
    private ProductServices productServices;
    
    @Override
    public void run(String... args) throws Exception {
        log.info("Starting ProductServices demonstration...");

        try {
            // Create sample digital products with IDs
            DigitalProduct game = new DigitalProduct(1, "Minecraft", 29.99, "minecraft.com/download");
            DigitalProduct software = new DigitalProduct(2, "Photoshop", 49.99, "adobe.com/download");
            DigitalProduct movie = new DigitalProduct(3, "Inception", 14.99, "movies.com/inception");

            // Set categories
            game.setCategory(ProductCategory.GAMING);
            software.setCategory(ProductCategory.SOFTWARE);
            movie.setCategory(ProductCategory.ENTERTAINMENT);

            // Add products to service
            log.info("Adding products to service...");
            productServices.addDigitalProduct(game);
            productServices.addDigitalProduct(software);
            productServices.addDigitalProduct(movie);

            // Display all products
            log.info("Displaying all products:");
            productServices.displayAllProducts();

            // Search by name
            log.info("Searching for 'photo' products:");
            var photoProducts = productServices.searchProductsByName("photo");
            if (!photoProducts.isEmpty()) {
                photoProducts.forEach(p -> log.info(p.toString()));
            } else {
                log.info("No products found containing 'photo'");
            }

            // Filter by category
            log.info("Getting all gaming products:");
            var gamingProducts = productServices.getProductsByCategory(ProductCategory.GAMING);
            if (!gamingProducts.isEmpty()) {
                gamingProducts.forEach(p -> log.info(p.toString()));
            } else {
                log.info("No gaming products found");
            }

            // Price range filter
            log.info("Products between $20 and $50:");
            var priceRangeProducts = productServices.getProductsByPriceRange(20.0, 50.0);
            if (!priceRangeProducts.isEmpty()) {
                priceRangeProducts.forEach(p -> log.info(p.toString()));
            } else {
                log.info("No products found in price range");
            }

            // Apply discount
            log.info("Applying 20% discount to all products...");
            productServices.applyDiscountToAll(20.0);
            
            // Calculate total inventory value
            double totalValue = productServices.calculateTotalInventoryValue();
            log.info("Total inventory value: ${}", String.format("%.2f", totalValue));

            // Remove a product
            log.info("Removing Minecraft...");
            productServices.removeDigitalProduct(game);
            
            log.info("Final product count: {}", productServices.getProductCount());

        } catch (Exception e) {
            log.error("Error in product demonstration: {}", e.getMessage());
        }
    }
}
