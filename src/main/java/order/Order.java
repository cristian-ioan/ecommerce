package order;

import client.Client;
import product.Product;

public class Order {

    private int orderID;
    private Client client;
    private Product product;
    private String paymentType;
    private String deliveryType;
    private int totalValue;

    public Order(){

    }

    public Order(int orderID, Client client, Product product, String paymentType, String deliveryType, int totalValue) {
        this.orderID = orderID;
        this.client = client;
        this.product = product;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        this.totalValue = totalValue;
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
