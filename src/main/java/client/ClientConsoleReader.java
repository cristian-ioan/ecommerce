package client;

import java.util.Scanner;

public class ClientConsoleReader {

    public Client readClientData(){
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add personal details.");
        System.out.println("First name");
        client.setFirstName(scanner.nextLine());
        System.out.println("Last name");
        client.setLastName(scanner.nextLine());
        System.out.println("Address");
        client.setAddress(scanner.nextLine());
        System.out.println("Email address");
        client.setEmail(scanner.nextLine());
        System.out.println("Contact number");
        return client;
    }

    public static int insertClientId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the client ID you would like to delete:");
        int clientId = scanner.nextInt();
        return clientId;
    }

    public Client editAddress(Client client){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit user data:");
        System.out.println("Edit address:");
        client.setAddress(scanner.nextLine());
        return client;
    }

    public static void insertBankAccount(){
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected card payment. Add your bank details. 0 - Next");
        client.setBankAccount(scanner.nextLine());
    }

}
