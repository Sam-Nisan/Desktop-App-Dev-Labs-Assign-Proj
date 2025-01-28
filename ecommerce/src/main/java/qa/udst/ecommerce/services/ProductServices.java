package qa.udst.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import qa.udst.ecommerce.model.DigitalProduct;
import qa.udst.ecommerce.model.ProductCategory;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    private ArrayList<DigitalProduct> digitalProducts;

    public ProductServices() {
        this.digitalProducts = new ArrayList<DigitalProduct>();
    }

    public void addDigitalProduct(DigitalProduct digitalProduct) {
        if (digitalProduct == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.digitalProducts.add(digitalProduct);
    }

    public void removeDigitalProduct(DigitalProduct digitalProduct) {
        this.digitalProducts.remove(digitalProduct);
    }

    public ArrayList<DigitalProduct> getDigitalProducts() {
        return new ArrayList<>(this.digitalProducts);
    }

    public DigitalProduct getDigitalProductById(int productId) {
        return this.digitalProducts.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    public void updateDigitalProduct(int productId, DigitalProduct updatedProduct) {
        int index = -1;
        for (int i = 0; i < digitalProducts.size(); i++) {
            if (digitalProducts.get(i).getId() == productId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            digitalProducts.set(index, updatedProduct);
        }
    }

    public List<DigitalProduct> searchProductsByName(String name) {
        return digitalProducts.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<DigitalProduct> getProductsByPriceRange(double minPrice, double maxPrice) {
        return digitalProducts.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<DigitalProduct> getProductsByCategory(ProductCategory category) {
        return digitalProducts.stream()
                .filter(product -> product.getCategory() == category)
                .collect(Collectors.toList());
    }

    public int getProductCount() {
        return digitalProducts.size();
    }

    public void clearAllProducts() {
        digitalProducts.clear();
    }

    public double calculateTotalInventoryValue() {
        return digitalProducts.stream()
                .mapToDouble(DigitalProduct::getPrice)
                .sum();
    }

    public void applyDiscountToAll(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        digitalProducts.forEach(product -> 
            product.setPrice(product.calculateDiscount(discountPercentage)));
    }

    public void displayAllProducts() {
        if (digitalProducts.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        digitalProducts.forEach(DigitalProduct::displayInfo);
    }

    public void displayProductById(int productId) {
        DigitalProduct product = getDigitalProductById(productId);
        if (product != null) {
            product.displayInfo();
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }
}
