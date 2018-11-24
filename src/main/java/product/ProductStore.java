package product;
import java.util.*;

public class ProductStore extends GenericStore<Product>{

    private List<Product> productList = new ArrayList<>();

    @Override
    public Product add(Product value) {
        value.setIdProduct( generateIdProduct() );
        productList.add( value );
        return value;
    }

    @Override
    public void delete(Product value) {
        productList.remove( value );
    }

    @Override
    public void update(Product value) {
        Product oldProduct = getById( value.getIdProduct());
        productList.remove( oldProduct );
        productList.add( value );

    }

    @Override
    public List getAll() {
        Collections.sort( productList );
        return productList;
    }

    @Override
    public Product getById(int id) {
        for(Product product: productList){
            if(product.getIdProduct() == id){
                return product;
            }
        }
        return null;
    }


    private int generateIdProduct(){
        int maxProduct = 0;
        for (Product product: productList){
            if(maxProduct < product.getIdProduct()){
                maxProduct = product.getIdProduct();
            }
        }
        return maxProduct + 1;
    }

}