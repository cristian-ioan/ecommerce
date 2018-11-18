package order;

public class Order {

    private int orderID;
    private String paymentType;
    private String deliveryType;
    private int totalValue;

    public Order(){

    }

    public Order(int orderID, String paymentType, String deliveryType, int totalValue) {
        this.orderID = orderID;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        this.totalValue = totalValue;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}
