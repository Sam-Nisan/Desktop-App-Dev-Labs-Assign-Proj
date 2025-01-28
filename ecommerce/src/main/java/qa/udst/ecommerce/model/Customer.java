package qa.udst.ecommerce.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Customer {
    private int customerId;
    private String name;
    private String email;

    public void displayCustomerInfo() {
        log.info("Customer Information - ID: {}, Name: {}, Email: {}", 
                this.customerId, this.name, this.email);
    }
}
