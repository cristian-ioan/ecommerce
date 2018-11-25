package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericStore<T> {

    protected List<T> objectList;

    public GenericStore() {
        objectList = readJson();
    }

    public abstract T add(T value);
    public abstract void delete(T value);
    public abstract void update(T value);
    public abstract List<T> getAll();
    public abstract T getById(int id);

    protected abstract String getFilePath();
    protected abstract List<T> getListFromJson(Gson gson, Reader reader);


    protected List<T> readJson(){
        try(Reader reader = new InputStreamReader(new FileInputStream(getFilePath()), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            return getListFromJson( gson, reader );
        } catch (IOException e) {
            System.out.println("Exception occured: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    protected void writeJson() {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(getFilePath()) , "UTF-8")){
            Gson gson = new GsonBuilder().create();
            gson.toJson(getAll(), writer);
        } catch (IOException e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }
}
