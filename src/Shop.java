import Cart.Cart;
import Products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private final ArrayList<Product> listProduct = new ArrayList<>();

    public void addProduct(Product product) {
        if (!listProduct.contains(product)) {
            listProduct.add(product);
        }
    }

    public void printListProduct() {
        if (this.listProduct.isEmpty()) {
            System.out.println("Список товаров пуст");
        } else {
            System.out.println("Список товаров:");
            int counter = 1;
            for (Product product : this.listProduct) {
                System.out.println(counter + ". " + product);
                counter++;
            }
        }
    }

    private int[] selectionProduct(int maxSize) {
        Scanner sc = new Scanner(System.in);
        int numProduct = 0;
        int quantity = 0;
        while (true) {
            System.out.println("Введите номер выбранного товара или 0 для смены операции.");
            try {
                numProduct = sc.nextInt();
                if (numProduct == 0) {
                    break;
                }
                if (numProduct < 0 || (numProduct > maxSize)) {
                    System.out.println("Нет такого товара. Повторите ввод.");
                    sc.nextLine();
                    continue;
                }
                System.out.println("Введите количество товара: ");
                quantity = sc.nextInt();
                if (quantity <= 0) {
                    System.out.println("Введено некорректное количество. Повторите операцию.");
                    sc.nextLine();
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Введено не число. Повторите ввод.");
                sc.nextLine();
                continue;
            }
        }
        return new int[]{numProduct, quantity};
    }

    public int removeProductFromCart(Cart cart) {
        while (true) {
            if (cart.getSizeCart() == 0) {
                System.out.println("В корзине больше нет товаров");
                break;
            }
            cart.printCart();
            int[] select = this.selectionProduct(cart.getSizeCart());
            if (select[0] > 0) {
                cart.removeProduct(select[0] - 1, select[1]);
            } else {
                break;
            }
        }
        return -1;
    }

    public int addProductToCart(Cart cart) {
        this.printListProduct();
        while (true) {
            int[] select = this.selectionProduct(listProduct.size());
            if (select[0] > 0) {
                cart.addProduct(listProduct.get(select[0] - 1), select[1]);
            } else {
                break;
            }
        }
        return -1;
    }
}
