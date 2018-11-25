package order;

public class OrderConsoleWriter {

    public void displayOrders(Order order){
        System.out.println(order.getOrderID()+ " " +
                order.getClient() + " " +
                order.getProduct() + " " +
                order.getQuantity() + " " +
                order.getStatus());
    }

}