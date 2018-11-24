package order;

public class OrderConsoleWriter {

    public void displayOrders(Order order){
        System.out.println(order.getOrderID()+ " "+
                order.getPaymentType() + " " +
                order.getDeliveryType() + " " +
                order.getTotalValue());
    }

}