package product;

import com.google.gson.Gson;
import util.GenericStore;
import util.Paths;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductStore extends GenericStore<Product>{

    @Override
    public Product add(Product value) {
        value.setIdProduct( generateIdProduct() );
        objectList.add( value );
        writeJson();
        return value;
    }

    @Override
    public void delete(Product value) {
        objectList.remove( value );
        writeJson();
    }

    @Override
    public void update(Product value) {
        Product oldProduct = getById( value.getIdProduct());
//        objectList.remove( oldProduct );
        int idx = objectList.indexOf(value);
        objectList.add(idx, value);
//        objectList.add( value );
        writeJson();
    }

    @Override
    public List getAll() {
        Collections.sort( objectList );
        return objectList;
    }

    @Override
    public Product getById(int id) {
        for(Product product: objectList){
            if(product.getIdProduct() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    protected String getFilePath() {
        return Paths.PRODUCTS_FILE_PATH;
    }

    @Override
    protected List<Product> getListFromJson(Gson gson, Reader reader) {
        return new ArrayList<>(Arrays.asList(gson.fromJson(reader, Product[].class)));
    }

    private int generateIdProduct(){
        int maxProduct = 0;
        for (Product product: objectList){
            if(maxProduct < product.getIdProduct()){
                maxProduct = product.getIdProduct();
            }
        }
        return maxProduct + 1;
    }

}