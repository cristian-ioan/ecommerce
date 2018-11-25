package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.GenericStore;
import util.Paths;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientStore extends GenericStore<Client> {

    @Override
    public Client add(Client value) {
        value.setIdClient( generateId() );
        objectList.add( value );
        writeJson();
        return value;
    }

    private int generateId(){
        int max = 0;
        for (Client client: objectList){
            if(max<client.getIdClient()){
                max=client.getIdClient();
            }
        }
        return max+1;
    }

    @Override
    public void delete(Client value) {
        objectList.remove( value );
        writeJson();
    }

    @Override
    public void update(Client value) {
        Client oldClient = getById( value.getIdClient());
        objectList.remove( oldClient );
        objectList.add( value );
        writeJson();
    }

    @Override
    public List<Client> getAll() {
        Collections.sort(objectList);
        return objectList;
    }

    @Override
    public Client getById(int id) {
        for(Client client:objectList){
            if(client.getIdClient() == id){
                return client;
            }
        }
        return null;
    }

    @Override
    protected String getFilePath() {
        return Paths.CLIENTS_FILE_PATH;
    }

    @Override
    protected List<Client> getListFromJson(Gson gson, Reader reader) {
        return Arrays.asList(gson.fromJson(reader, Client[].class));
    }
}
