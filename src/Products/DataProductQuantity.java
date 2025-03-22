package Products;

public class DataProductQuantity {
    private final Product product;
    private int quantity;

    public DataProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max((this.quantity + quantity), 0);
    }
}
