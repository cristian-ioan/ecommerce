import client.ClientConsoleMenu;
import order.OrderConsoleMenu;
import product.Product;
import product.ProductConsoleMenu;
import product.ProductConsoleWriter;

import java.util.Scanner;

public class ConsoleMenu {
    private ClientConsoleMenu clientConsoleMenu = new ClientConsoleMenu();
    private OrderConsoleMenu orderConsoleMenu = new OrderConsoleMenu();
    private ProductConsoleMenu productConsoleMenu = new ProductConsoleMenu();

    public void displayConsoleMenu() {
        System.out.println( "Console Menu:" );
        System.out.println( "1. Products" );
        System.out.println( "2. Orders" );
        System.out.println( "3. Clients" );
        System.out.println( "0. Exit" );
        Scanner scanner = new Scanner( System.in );
        int option;
        do {
            System.out.println("Select menu option: ");
            option =  scanner.nextInt();
            switch (option) {
                case 1: productConsoleMenu.displayMenuProducts();
                    break;
                case 2: orderConsoleMenu.displayMenuOrders();
                    break;
                case 3:
                    clientConsoleMenu.displayMenuClients();
                    break;
                case 0:
                    break;
                }
            } while (option != 0);
        }
    }