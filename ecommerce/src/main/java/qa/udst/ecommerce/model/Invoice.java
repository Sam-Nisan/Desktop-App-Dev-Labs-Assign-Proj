package qa.udst.ecommerce.model;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    private int invoiceId;
    private Order order;
    private Date date;

    public void generateInvoice() {
        System.out.println("Invoice generated for Order ID: " + this.order.getOrderId());
        this.order.calculateTotal();
        System.out.println("Total Price: $" + this.order.getTotalPrice());
        System.out.println("Invoice generated successfully!");
    }

    public void displayInvoice() {
        System.out.println("Invoice ID: " + this.invoiceId);
        System.out.println("Date: " + this.date);
        this.order.displayOrder();
    }
}
