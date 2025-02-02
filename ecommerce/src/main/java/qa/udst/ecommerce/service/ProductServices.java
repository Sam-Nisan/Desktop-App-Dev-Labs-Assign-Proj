package qa.udst.ecommerce.service;

import qa.udst.ecommerce.model.*;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductServices {
    private final Map<Long, BaseProduct> products;
    private final AtomicLong idGenerator;

    public ProductServices() {
        this.products = new HashMap<>();
        this.idGenerator = new AtomicLong(1);
    }

    public List<BaseProduct> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public BaseProduct getProductById(Long id) {
        BaseProduct product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return product;
    }

    public Long addProduct(BaseProduct product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        Long id = idGenerator.getAndIncrement();
        product.setId(id.intValue());
        products.put(id, product);
        return id;
    }

    public void updateProduct(Long id, BaseProduct updatedProduct) {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        updatedProduct.setId(id.intValue());
        products.put(id, updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        products.remove(id);
    }

    public List<BaseProduct> searchProducts(String name) {
        return products.values().stream()
            .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
            .toList();
    }

    public List<BaseProduct> getProductsByCategory(ProductCategory category) {
        return products.values().stream()
            .filter(product -> product.getCategory() == category)
            .toList();
    }

    public double calculateTotalInventoryValue() {
        return products.values().stream()
            .mapToDouble(BaseProduct::getPrice)
            .sum();
    }

    public void applyDiscountToAll(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        products.values().forEach(product -> 
            product.setPrice(product.calculateDiscount(discountPercentage)));
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        products.values().forEach(BaseProduct::displayInfo);
    }
}
