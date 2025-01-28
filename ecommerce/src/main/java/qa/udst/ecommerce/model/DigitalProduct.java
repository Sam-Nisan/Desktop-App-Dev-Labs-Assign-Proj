package qa.udst.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DigitalProduct extends BaseProduct {
    @NotBlank(message = "Download link cannot be blank")
    private String downloadLink;

    public DigitalProduct(String name, double price, String downloadLink) {
        super(name, price, ProductCategory.DIGITAL);
        this.downloadLink = downloadLink;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Download Link: " + downloadLink);
    }
}
