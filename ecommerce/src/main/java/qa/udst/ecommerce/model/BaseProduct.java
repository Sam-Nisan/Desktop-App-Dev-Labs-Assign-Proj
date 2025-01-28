package qa.udst.ecommerce.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseProduct {
    private int id;
    private String name;
    private double price;
    private ProductCategory category;

    public BaseProduct(String name, double price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
    }

    public double calculateDiscount(double percentage) {
        return price * (1 - percentage / 100);
    }
}