package product;

import java.util.List;
import java.util.Scanner;

public class ProductConsoleMenu {

    ProductService productService = ProductService.getInstance();
    ProductConsoleWriter productWriter = new ProductConsoleWriter();
    ProductConsoleReader productConsoleReader = new ProductConsoleReader();

    public void displayMenuProducts() {
        Scanner scanner = new Scanner( System.in );
        int option;
        do {
            displayProductOptions();
            System.out.print("Select option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3: editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }

    private void displayProductOptions() {
        System.out.println( "1. Display all products" );
        System.out.println( "2. Add product" );
        System.out.println( "3. Edit product" );
        System.out.println( "4. Delete product" );
        System.out.println( "0. Exit" );
        System.out.println( "Select your option" );
    }

    private void displayProducts() {
        List<Product> allProducts = productService.getAllProducts();
        for (Product product : allProducts) {
            productWriter.displayProductData(product);
        }
    }

    private void addProduct() {
        ProductConsoleReader productReader = new ProductConsoleReader();
        Product product = productReader.readProductData();
        productService.addProduct( product );
        System.out.println( "Product successfully added!" );
    }

    private void deleteProduct(){
        Scanner scanner = new Scanner( System.in );
        System.out.print("Which product do you want to delete? Enter ID: ");
        int id = scanner.nextInt();
        Product product = productService.getProductById( id );
        productService.deleteProduct( product );
    }

    private void editProduct(){
        Scanner scanner = new Scanner( System.in );
        System.out.print("Which product do you want to edit? Enter ID: ");
        int id = scanner.nextInt();
        Product product= productService.getProductById( id );
        product = productConsoleReader.editPrice( product );
        productService.updateProduct( product );
        product = productConsoleReader.editStock( product );
        productService.updateProduct( product );
    }

}