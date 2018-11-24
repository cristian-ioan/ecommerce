package order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderStore extends client.GenericStore<Order> {

    private List<Order> orderList = new ArrayList<>();

    @Override
    public Order add(Order value) {
        value.setOrderID(generateId());
        orderList.add(value);
        return value;
    }

    private int generateId(){
        int max = 0;
        for (Order order: orderList){
            if(max < order.getOrderID()){
                max = order.getOrderID();
            }
        }
        return max+1;
    }

    @Override
    public void delete(Order value) {
        orderList.remove( value );

    }

    @Override
    public void update(Order value) {
        Order oldOrder = getById( value.getOrderID());
        orderList.remove(oldOrder);
        orderList.add( value );

    }

    @Override
    public List<Order> getAll() {
        Collections.sort(orderList);
        return orderList;
    }

    @Override
    public Order getById(int id) {
        for(Order order : orderList){
            if(order.getOrderID() == id){
                return order;
            }
        }
        return null;
    }

}