package order;

import client.Client;
import client.ClientConsoleReader;
import client.ClientConsoleWriter;
import client.ClientService;
import product.Product;
import product.ProductService;

import java.util.Scanner;

public class OrderConsoleReader {

    private ClientConsoleWriter clientWritter = new ClientConsoleWriter();
    private ClientConsoleReader clientReader = new ClientConsoleReader();
    ClientService clientService = ClientService.getInstance();
    ProductService productService = ProductService.getInstance();
    OrderService orderService = OrderService.getInstance();

    public Order readOrderData() {

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        Client client = null;
        while (client == null) {

            System.out.println("Add client ID:");
            int clientId = scanner.nextInt();
            client = clientService.getClientById(clientId);

            if (client == null) {
                System.out.println("Insert a valid client ID");
            }
        }
        order.setClient(client);
        Product product = null;
        while (product == null) {

            System.out.println("Add product ID:");
            int productId = scanner.nextInt();
            product = productService.getProductById(productId);

            if (product == null) {
                System.out.println("Insert a valid product ID");
            }
        }
        order.setProduct(product);
        int quantity = 0;
        while (quantity <= 0) {

            System.out.println("Add quantity:");
            quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("Insert a valid quantity");
            }
        }
        order.setQuantity(quantity);
        return order;
    }

    public void cancelOrder() {
        System.out.println("Enter order ID you want to cancel");
        Scanner scanner = new Scanner(System.in);

        Order order = null;
        while (order == null) {

            System.out.println("Add order ID:");
            int orderId = scanner.nextInt();
            order = orderService.getOrderById(orderId);
            orderService.cancelOrder(orderId);

            if (order == null) {
                System.out.println("Insert a valid order ID");
            }
        }
        System.out.println("Order was canceled.");
    }

    public Order editQuantity(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit quantity:");
        order.setQuantity(scanner.nextInt());

        return order;
    }

}