package product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ProductConsoleWriter {


    public void displayProductData(Product product){
        System.out.println(product.getIdProduct()+ " "+
                product.getCategoryName() + " " +
                product.getProductName() + " " +
                product.getPriceProduct() + " " +
                product.getStockProduct());
    }

//    public void writeJson() throws IOException{
//        Product product = new Product( 1, "manusi", "manusi din piele", 20, 10 );
//        try(Writer writer = new OutputStreamWriter(new FileOutputStream("D:/WS/ecommerce/productList.json") , "UTF-8")){
//            Gson gson = new GsonBuilder().create();
//            gson.toJson(product, writer);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        ProductConsoleWriter productConsoleWriter = new ProductConsoleWriter();
//        productConsoleWriter.writeJson();
//    }

}