package product;

import java.util.List;

public class ProductService {

    ProductStore productStore = new ProductStore();

    //singleton, o singura instanta per clasa
    private static ProductService productService = new ProductService();

    //facem constructor privat
    private ProductService(){
    }

    public static ProductService getInstance(){
        return productService;
    }

    public void addProduct(Product product) {
        productStore.add( product );
    }

    public void deleteProduct(Product product) {
        productStore.delete( product );
    }

    public Product getProductById(int id) {
        return productStore.getById( id );
    }

    public void updateProduct(Product product) {
        productStore.update( product );
    }

    public List<Product> getAllProducts() {
        return productStore.getAll();
    }

}
