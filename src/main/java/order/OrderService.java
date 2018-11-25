package order;

import client.Client;
import client.ClientService;
import product.Product;
import product.ProductService;

import java.util.List;

public class OrderService {

    OrderStore orderStore = new OrderStore();
    //instanta de clasa clientService
    ClientService clientService = ClientService.getInstance();
    ProductService productService = ProductService.getInstance();
    //singleton, o singura instanta per clasa
    private static OrderService orderService = new OrderService();

    //facem constructor privat
    private OrderService(){

    }

    public static OrderService getInstance(){
        return orderService;
    }


    public boolean isValidStock(int idProduct, int quantity) {
        Product product = productService.getProductById(idProduct);
        boolean isValidProductOrder = false;
//        for (Product product : allProducts) {
//            if (product.getIdProduct() == (idProduct)) {
                if (product.getStockProduct() >= quantity) {
                    isValidProductOrder = true;
                } else {
                    System.out.println("Not enough stock!");
                }
//            } else {
//                System.out.println("Product not found!");
//            }
//        }
        return isValidProductOrder;
    }

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
        if (isValidStock(order.getProduct().getIdProduct(), order.getQuantity())) {
            //scadem din stock
            int stock = order.getProduct().getStockProduct();
            order.getProduct().setStockProduct(stock - order.getQuantity());
            //setam in order in order
            order.setStatus(OrderStatusType.IN_PROGRESS);

        }
        orderStore.add(order);
        productService.updateProduct(order.getProduct());
    }

    public void cancelOrder(int idOrder){
        Order order = orderStore.getById(idOrder);
        if(order.getOrderID()==idOrder){
            System.out.println("Order is found");
            order.setStatus(OrderStatusType.CANCELED);
           int stock = order.getProduct().getStockProduct();
           stock = stock + order.getQuantity();
           order.getProduct().setStockProduct(stock);
           order.setQuantity(0);
        }else{
            System.out.println("Order not found");
        }
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