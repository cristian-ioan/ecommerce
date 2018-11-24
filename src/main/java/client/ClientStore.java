package client;

import java.util.ArrayList;
import java.util.List;

public class ClientStore extends GenericStore<Client> {
    private List<Client> clientList = new ArrayList<>();

    @Override
    public Client add(Client value) {
        value.setIdClient( generateId() );
        clientList.add( value );
        return value;
    }

    private int generateId(){
        int max = 0;
        for (Client client: clientList){
            if(max<client.getIdClient()){
                max=client.getIdClient();
            }
        }
        return max+1;
    }

    @Override
    public void delete(Client value) {
        clientList.remove( value );
    }

    @Override
    public void update(Client value) {
        Client oldClient = getById( value.getIdClient());
        clientList.remove( oldClient );
        clientList.add( value );
    }

    @Override
    public List<Client> getAll() {
        return clientList;
    }

    @Override
    public Client getById(int id) {
        for(Client client:clientList){
            if(client.getIdClient() == id){
                return client;
            }
        }
        return null;
    }
}
