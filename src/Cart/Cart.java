package Cart;

import Products.DataProductQuantity;
import Products.Product;

import java.util.ArrayList;

public class Cart implements CartInterface {
    private final ArrayList<DataProductQuantity> cartList = new ArrayList<>();

    public boolean hashCart() {
        return !cartList.isEmpty();
    }

    public int getSizeCart() {
        return cartList.size();
    }

    @Override
    public void addProduct(Product product, int quantity) {
        for (DataProductQuantity dataProduct : cartList) {
            if (dataProduct.getProduct() == product) {
                dataProduct.setQuantity(dataProduct.getQuantity() + quantity);
                System.out.println("Количество товара " + product + " увеличено на " + quantity);
                return;
            }
        }
        cartList.add(new DataProductQuantity(product, quantity));
        System.out.println("Товар " + product + " " + quantity + " шт добавлен в корзину");
    }

    @Override
    public void removeProduct(int productIdx, int quantity) {
        DataProductQuantity dataProduct = cartList.get(productIdx);
        int resultQuantity = dataProduct.getQuantity() - quantity;
        if (resultQuantity <= 0) {
            cartList.remove(dataProduct);
            System.out.println("Товара " + dataProduct.getProduct()
                    + " в корзине отрицательное количество, он удален.");
            return;
        }
        dataProduct.setQuantity(-quantity);
        System.out.println("Количество товара "
                + dataProduct.getProduct() + " уменьшено на "
                + quantity + " и составляет шт: "
                + dataProduct.getQuantity());
    }

    @Override
    public void clearCart() {
        cartList.clear();
        System.out.println("Все товары удалены из корзины");
    }

    @Override
    public void printCart() {
        System.out.println("Товары в корзине:");
        double sum = 0;
        int counter = 1;

        for (DataProductQuantity dataProduct : cartList) {
            System.out.println(counter + ". " + dataProduct.getProduct() + " - " + dataProduct.getQuantity() + " шт");
            counter++;
            sum += dataProduct.getProduct().getPrice() * dataProduct.getQuantity();
        }
        System.out.println("Общая сумма корзины: " + sum);
    }

}
