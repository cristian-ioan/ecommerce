package order;

import java.util.List;

public class OrderService {

    OrderConsoleReader orderReader = new OrderConsoleReader();
    OrderStore orderStore = new OrderStore();

    public void addOrder(Order order) {
        //TODO: validate product and client
        //TODO: validate and subtract from stock
        orderStore.add(order);

    }

    //TODO: cancel order
    public void cancelOrder(Order order){
        //TODO: validate that order exists
        //TODO: update status to OrderStatusType.CANCELED
        //TODO: return products to stock
    }

    public void deleteOrder(Order order) {
        orderStore.delete(order);

    }

    public Order getOrderById(int id){
        return orderStore.getById(id);
    }

    public void updateOrder(Order order){
        orderStore.update(order);
    }

    public List<Order> getAllOrders(){
        return orderStore.getAll();
    }
}