package order;

import java.util.List;

public class OrderService {

    OrderConsoleReader orderReader = new OrderConsoleReader();
    OrderStore orderStore = new OrderStore();

    public void addOrder(Order order) {
        orderStore.add(order);
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
