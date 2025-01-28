package qa.udst.ecommerce.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Order {
    private int orderId;
    private ArrayList<BaseProduct> products = new ArrayList<>();
    private double totalPrice;
    private Customer customer;

    public void addProduct(BaseProduct product) {
        this.products.add(product);
        log.debug("Added product {} to order {}", product.getName(), orderId);
    }

    public void calculateTotal() {
        this.totalPrice = 0.0;
        for (BaseProduct product : products) {
            this.totalPrice += product.getPrice();
        }
        log.debug("Calculated total price for order {}: ${}", orderId, totalPrice);
    }

    public void displayOrder() {
        log.info("Order Details - ID: {}", this.orderId);
        log.info("Customer Details:");
        this.customer.displayCustomerInfo();
        log.info("Products in order:");
        for (BaseProduct product : products) {
            log.info("- {}: ${}", product.getName(), product.getPrice());
        }
        log.info("Total Price: ${}", this.totalPrice);
    }
}
