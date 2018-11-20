package product;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductService {

    ProductStore productStore = new ProductStore();

    public void addProduct(Product product) {
        productStore.add(product);    }

    public void deleteProduct(Product product) {
        productStore.delete( product );    }

    public Product getProductById(int id){
        return productStore.getById( id );
    }
    public void updateProduct(Product product){
        productStore.update( product );
    }
    public List<Product> getAllProducts(){
        return productStore.getAll();
    }


}
