package product;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private int idProduct;
    private String categoryName;
    private String productName;
    private double priceProduct;
    private int stockProduct;

    public Product() {
    }

    public Product(int idProduct, String categoryName, String productName, double priceProduct, int stockProduct ){
        this.idProduct = idProduct;
        this.categoryName = categoryName;
        this.productName = productName;
        this.priceProduct = priceProduct;
        this.stockProduct = stockProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(int stockProduct) {
        this.stockProduct = stockProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct + "\n" +
                ", categoryName='" + categoryName + '\'' + "\n" +
                ", productName='" + productName + '\'' + "\n" +
                ", priceProduct=" + priceProduct + "\n" +
                ", stockProduct=" + stockProduct + "\n" +
                '}';
    }

    @Override
    public int compareTo(Product o) {
//        if (idProduct<o.idProduct){
//            return -1;
//        } else if(idProduct==o.idProduct){
//            return 0;
//        } else {
//            return 1;
//        }
        return idProduct - o.idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getIdProduct() == product.getIdProduct();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduct());
    }
}