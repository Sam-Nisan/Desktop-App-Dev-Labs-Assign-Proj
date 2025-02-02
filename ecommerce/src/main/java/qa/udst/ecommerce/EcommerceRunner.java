package qa.udst.ecommerce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qa.udst.ecommerce.model.*;
import qa.udst.ecommerce.service.ProductServices;
import java.util.List;

@Component
@Slf4j
public class EcommerceRunner implements CommandLineRunner {
    
    @Autowired
    private ProductServices productServices;
    
    @Override
    public void run(String... args) {
        log.info("Starting E-commerce System Tests...");

        try {
            testProductCreation();
            testProductRetrieval();
            testProductUpdates();
            testProductDeletion();
            testProductSearch();
            testProductFiltering();
            testShippingCalculations();
            
            log.info("All tests completed successfully!");
        } catch (Exception e) {
            log.error("Test execution failed: {}", e.getMessage());
        }
    }

    private void testProductCreation() {
        log.info("=== Testing Product Creation ===");
        
        // Create Digital Product
        DigitalProduct software = new DigitalProduct("Antivirus Plus", 49.99, "http://download.com/av");
        Long digitalId = productServices.addProduct(software);
        log.info("Created digital product with ID: {}", digitalId);
        
        // Create Physical Product
        PhysicalProduct laptop = new PhysicalProduct("Gaming Laptop", 1299.99, 2.5);
        Long physicalId = productServices.addProduct(laptop);
        log.info("Created physical product with ID: {}", physicalId);
    }

    private void testProductRetrieval() {
        log.info("=== Testing Product Retrieval ===");
        
        List<BaseProduct> allProducts = productServices.getAllProducts();
        log.info("Total products in system: {}", allProducts.size());
        
        allProducts.forEach(product -> {
            log.info("Product: {} - Price: ${}", product.getName(), product.getPrice());
        });
    }

    private void testProductUpdates() {
        log.info("=== Testing Product Updates ===");
        
        try {
            BaseProduct product = productServices.getProductById(1L);
            product.setPrice(product.getPrice() * 1.1); // 10% price increase
            productServices.updateProduct(1L, product);
            log.info("Successfully updated product price");
        } catch (ProductNotFoundException e) {
            log.error("Product update failed: {}", e.getMessage());
        }
    }

    private void testProductDeletion() {
        log.info("=== Testing Product Deletion ===");
        
        try {
            productServices.deleteProduct(1L);
            log.info("Successfully deleted product");
        } catch (ProductNotFoundException e) {
            log.error("Product deletion failed: {}", e.getMessage());
        }
    }

    private void testProductSearch() {
        log.info("=== Testing Product Search ===");
        
        List<BaseProduct> searchResults = productServices.searchProducts("Gaming");
        log.info("Found {} products matching 'Gaming'", searchResults.size());
    }

    private void testProductFiltering() {
        log.info("=== Testing Product Filtering ===");
        
        List<BaseProduct> digitalProducts = productServices.getProductsByCategory(ProductCategory.DIGITAL);
        log.info("Found {} digital products", digitalProducts.size());
    }

    private void testShippingCalculations() {
        log.info("=== Testing Shipping Calculations ===");
        
        productServices.getAllProducts().stream()
            .filter(p -> p instanceof PhysicalProduct)
            .map(p -> (PhysicalProduct) p)
            .forEach(p -> {
                double shippingCost = p.calculateShippingCost();
                String trackingNumber = p.generateTrackingNumber();
                log.info("Product: {} - Shipping: ${} - Tracking: {}", 
                    p.getName(), shippingCost, trackingNumber);
            });
    }
}
