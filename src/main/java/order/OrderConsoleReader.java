package order;

import client.ClientConsoleReader;
import client.ClientConsoleWriter;

import java.util.Scanner;

public class OrderConsoleReader {

    private ClientConsoleWriter clientWritter = new ClientConsoleWriter();
    private ClientConsoleReader clientReader = new ClientConsoleReader();

    public Order readOrderData(){

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Continue order. Select payment type:");
        System.out.println("1. Credit Card");
        System.out.println("2. Ramburs");
        int option;
        do {
        option = scanner.nextInt();
        switch (option) {
            case 1: clientReader.insertBankAccount();
                break;
            case 2: System.out.println("You selected to pay cash.");
                break;
        }
    } while (option != 0);

        System.out.println("Select delivery type: ");
        System.out.println("1. Currier");
        System.out.println("2. Personal Collecting");
        option = scanner.nextInt();
        return order;
    }

    public int insertOrderId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the order ID you would like to delete.");
        int orderId = scanner.nextInt();
        return orderId;
    }

    public Order editOrder(Order order){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit order data.");
        System.out.println("Edit payment type");
        order.setPaymentType(scanner.nextLine());
        System.out.println("Edit delivery type");
        order.setDeliveryType(scanner.nextLine());
        return order;
    }
}
