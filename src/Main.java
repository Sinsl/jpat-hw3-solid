import Cart.Cart;
import Products.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop();
        shop.addProduct(new Product("iPhone 15 Pro", "Apple", 87000.00));
        shop.addProduct(new Product("iPhone 14", "Apple", 66000.00));
        shop.addProduct(new Product("Galaxy S24", "Samsung", 80000.00));
        shop.addProduct(new Product("Galaxy S22", "Samsung", 45000.00));
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        int numGoTo = -1;
        while (numGoTo != 0) {
            if (numGoTo < 0) {
                System.out.println("Введите номер действия:");
                for (Menu goTo : Menu.values()) {
                    System.out.println(goTo.ordinal() + " - " + goTo.getDescription());
                }
                if (scanner.hasNextInt()) {
                    numGoTo = scanner.nextInt();
                } else {
                    System.out.println("Введенный символ не является числом. Повторите");
                    numGoTo = -1;
                }
                scanner.nextLine();
                continue;
            }
            numGoTo = switch (numGoTo) {
                case 1 -> {
                    System.out.print("Выбрано " + Menu.values()[numGoTo].getDescription() + "\n");
                    yield shop.addProductToCart(cart);
                }
                case 2 -> {
                    System.out.print("Выбрано " + Menu.values()[numGoTo].getDescription() + "\n");
                    if (cart.hashCart()) {
                        yield shop.removeProductFromCart(cart);
                    } else {
                        System.out.println("Корзина пуста. Давайте добавим туда товары");
                        yield 1;
                    }
                }
                case 3 -> {
                    System.out.print("Выбрано " + Menu.values()[numGoTo].getDescription() + "\n");
                    cart.clearCart();
                    yield -1;
                }
                case 4 -> {
                    System.out.print("Выбрано " + Menu.values()[numGoTo].getDescription() + "\n");
                    if (cart.hashCart()) {
                        cart.printCart();
                    } else {
                        System.out.println("Корзина пуста. Давайте добавим туда товары");
                        yield 1;
                    }
                    yield -1;
                }
                default -> {
                    System.out.println("Нет такой операции. Повторите ввод" + "\n");
                    yield -1;
                }
            };
        }
        System.out.print("Выбрано " + Menu.values()[numGoTo].getDescription());
        scanner.close();
    }
}