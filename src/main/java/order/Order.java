package order;

import client.Client;
import product.Product;

public class Order implements Comparable <Order>{

    private int orderID;
    private Client client;
    private Product product;
    private PaymentType paymentType;
    private DeliveryType deliveryType;
    private int totalValue;
    private int quantity;
    private OrderStatusType status;

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public Order(){

    }

    public Order(int orderID, Client client, Product product, PaymentType paymentType, DeliveryType deliveryType, int totalValue, int quantity) {
        this.orderID = orderID;
        this.client = client;
        this.product = product;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        this.totalValue = totalValue;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public int compareTo(Order o) {
        return orderID - o.orderID;
    }

}
