package client;

public class ClientConsoleWriter {

    public void displayClientData(Client client){
        System.out.println(client.getIdClient()+ " "+
                client.getFirstName() + " " +
                client.getLastName() + " " +
                client.getAddress() + " " +
                client.getEmail() + " " +
                client.getPhone());
    }
}
