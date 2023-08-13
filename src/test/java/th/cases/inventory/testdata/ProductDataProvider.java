package th.cases.inventory.testdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.testdata.AbstractDataProvider;
import constants.files.Files;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductDataProvider extends AbstractDataProvider {

    @DataProvider(name = "Products")
    public static Object[][] getProductData() {
        List<ProductItem> productItems = defaultProducts(); // Assuming you have a method to retrieve the list

        Object[][] data = new Object[productItems.size()][2];

        for (int i = 0; i < productItems.size(); i++) {
            data[i][0] = i;  // Index
            data[i][1] = productItems.get(i);  // ProductItem
        }

        return data;
    }

    private static List<ProductItem> defaultProducts() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                    Files.TestDataFiles.PRODUCTS,
                    new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error while parsing test data", e);
        }
    }
}