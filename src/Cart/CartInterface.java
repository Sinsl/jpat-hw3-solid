package Cart;

import Products.Product;

public interface CartInterface {
    public void addProduct(Product product, int quantity);
    public void removeProduct(int productIdx, int quantity);
    public void clearCart();
    public void printCart();
}
