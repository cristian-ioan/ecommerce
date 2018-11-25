package order;

import com.google.gson.Gson;
import util.GenericStore;
import util.Paths;

import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderStore extends GenericStore<Order> {

    @Override
    public Order add(Order value) {
        value.setOrderID(generateId());
        objectList.add(value);
        return value;
    }

    private int generateId(){
        int max = 0;
        for (Order order: objectList){
            if(max < order.getOrderID()){
                max = order.getOrderID();
            }
        }
        return max+1;
    }

    @Override
    public void delete(Order value) {
        objectList.remove( value );

    }

    @Override
    public void update(Order value) {
        Order oldOrder = getById( value.getOrderID());
        objectList.remove(oldOrder);
        objectList.add( value );

    }

    @Override
    public List<Order> getAll() {
        Collections.sort(objectList);
        return objectList;
    }

    @Override
    public Order getById(int id) {
        for(Order order : objectList){
            if(order.getOrderID() == id){
                return order;
            }
        }
        return null;
    }

    @Override
    protected String getFilePath() {
        return Paths.ORDERS_FILE_PATH;
    }

    @Override
    protected List<Order> getListFromJson(Gson gson, Reader reader) {
        return Arrays.asList(gson.fromJson(reader, Order[].class));
    }
}