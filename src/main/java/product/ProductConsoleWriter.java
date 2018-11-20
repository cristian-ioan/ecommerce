package product;

import java.util.Map;
import java.util.Scanner;

public class ProductConsoleWriter {

    public void displayProductData(Product product){
        System.out.println(product.getIdProduct()+ " "+
                product.getCategoryName() + " " +
                product.getProductName() + " " +
                product.getPriceProduct() + " " +
                product.getStockProduct());
    }

}
