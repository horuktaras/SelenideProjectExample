package th.cases.inventory.testdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductItem {
    String images;
    String name;
    String description;
    Double price;
}
