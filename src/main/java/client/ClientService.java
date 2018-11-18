package client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ClientService {
    ClientConsoleReader clientReader = new ClientConsoleReader();
    ClientStore clientStore = new ClientStore();



    public void addClient(Client client) {
        clientStore.add(client);
    }

    public void deleteClient(Client client) {
        clientStore.delete( client );

    }

    public Client getClientById(int id){
       return clientStore.getById( id );
    }

    public void updateClient(Client client){
        clientStore.update( client );
    }



   public List<Client> getAllClients(){
        return clientStore.getAll();
   }

}
