package order;

import java.util.List;
import java.util.Scanner;

public class OrderConsoleMenu {

    OrderService orderService = new OrderService();
    OrderConsoleWritter orderWritter = new OrderConsoleWritter();
    OrderConsoleReader orderReader = new OrderConsoleReader();

    public void displayMenuOrders() {

        Scanner scanner = new Scanner( System.in );
        int option;
        do {

            displayOrderOptions();
            System.out.println("Select option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1: displayOrders();
                    break;
                case 2: addOrder();
                    break;
                case 3: editOrder();
                    break;
                case 4: deleteOrder();
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }

    private void displayOrderOptions() {
        System.out.println( "1. Display all orders" );
        System.out.println( "2. Add order" );
        System.out.println( "3. Edit order" );
        System.out.println( "4. Delete order" );
        System.out.println( "0. Exit" );
    }

    private void displayOrders() {
        List<Order> allOrders = orderService.getAllOrders();
        for (Order order : allOrders) {
            orderWritter.displayOrders(order);
        }
    }

    private void addOrder() {
        OrderConsoleReader orderReader = new OrderConsoleReader();
        Order order = orderReader.readOrderData();
        orderService.addOrder(order);
        System.out.println( "Order successfully added." );
    }

    private void deleteOrder(){
        Scanner scanner = new Scanner( System.in );
        System.out.print("Which order do you want to delete? Enter ID: ");
        int id = scanner.nextInt();
        Order order = orderService.getOrderById(id);
        orderService.deleteOrder(order);
    }
    private void editOrder(){
        Scanner scanner = new Scanner( System.in );
        System.out.print("Which order do you want to edit? Enter ID: ");
        int id = scanner.nextInt();
        Order order = orderService.getOrderById(id);
        order = orderReader.editOrder(order);
        orderService.updateOrder(order);
    }
}
