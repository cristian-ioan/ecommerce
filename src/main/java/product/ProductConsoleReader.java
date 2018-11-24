package product;

import java.util.Scanner;

public class ProductConsoleReader {

    public Product readProductData(){
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add product details.");
        System.out.println("Category name: ");
        product.setCategoryName(scanner.nextLine());
        System.out.println("Product name: ");
        product.setProductName(scanner.nextLine());
        System.out.println("Price: ");
        product.setPriceProduct(scanner.nextDouble());
        System.out.println("Stock: ");
        product.setStockProduct(scanner.nextInt());
        return product;
    }

    public static int insertProductId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Insert ID of the product you would like to find.");
        int productId = scanner.nextInt();
        return productId;
    }

    public Product editPrice(Product product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit price: ");
        product.setPriceProduct(scanner.nextDouble());
        return product;
    }

    public Product editStock(Product product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit stock: ");
        product.setStockProduct(scanner.nextInt());
        return product;
    }

}