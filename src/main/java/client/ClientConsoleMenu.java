package client;

import java.util.List;
import java.util.Scanner;

public class ClientConsoleMenu {
    ClientService clientService = new ClientService();
    ClientConsoleWriter clientWriter = new ClientConsoleWriter();
    ClientConsoleReader clientConsoleReader = new ClientConsoleReader();
    public void displayMenuClients() {

        Scanner scanner = new Scanner( System.in );
        int option;
        do {
            displayClientOptions();
            System.out.print("Select option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayClients();
                    break;
                case 2:
                    addClient();
                    break;
                case 3: editClient();
                    break;
                case 4:
                    deleteClient();
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }

    private void displayClientOptions() {
        System.out.println( "1. Display all clients" );
        System.out.println( "2. Add client" );
        System.out.println( "3. Edit client" );
        System.out.println( "4. Delete client" );
        System.out.println( "0. Exit" );
        System.out.println( "Select your option" );
    }

    private void displayClients() {
        List<Client> allClients = clientService.getAllClients();
        for (Client client : allClients) {
            clientWriter.displayClientData(client);
        }
    }

    private void addClient() {
        ClientConsoleReader clientReader = new ClientConsoleReader();
        Client client = clientReader.readClientData();
        clientService.addClient( client );
        System.out.println( "Client successfully added." );
    }

    private void deleteClient(){
        Scanner scanner = new Scanner( System.in );
        System.out.print("Which client do you want to delete? Enter ID: ");
        int id = scanner.nextInt();
        Client client= clientService.getClientById( id );
        clientService.deleteClient( client );
    }
    private void editClient(){
        Scanner scanner = new Scanner( System.in );
        System.out.print("Which client do you want to edit? Enter ID: ");
        int id = scanner.nextInt();
        Client client= clientService.getClientById( id );
        client = clientConsoleReader.editAddress( client );
        clientService.updateClient( client );

    }
}
