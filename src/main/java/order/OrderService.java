package order;

import client.Client;
import client.ClientService;
import product.Product;
import product.ProductService;

import java.util.List;

public class OrderService {

    OrderConsoleReader orderReader = new OrderConsoleReader();
    OrderStore orderStore = new OrderStore();

    ClientService clientService = ClientService.getInstance();
    ProductService productService = ProductService.getInstance();

    public boolean isValidProductOrder(int idProduct, int quantity) {
        boolean isValidProductOrder = false;
        Product findProduct = productService.getProductById(idProduct);
        if (findProduct != null) {
            if (findProduct.getStockProduct() >= quantity) {
                isValidProductOrder = true;
            } else {
                System.out.println("Not enough stock!");
            }
        } else {
            System.out.println("Product not found!");
        }
        return isValidProductOrder;
    }

    public boolean isValidClient(int idClient) {
        boolean isValidClient = false;
        Client findClient = clientService.getClientById(idClient);
        if (findClient != null) {
            isValidClient = true;
        } else {
            System.out.println("Client not found!");
        }
        return isValidClient;
    }

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