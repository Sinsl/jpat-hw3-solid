public enum Menu {
    EXIT("Завершить покупки"),
    ADD("Добавить товар в корзину"),
    DELETE("Удалить товар из корзины"),
    CLEAR("Очистить корзину"),
    CART("Посмотреть корзину"),
    DELIVERY("Оформить доставку");

    private final String description;

    private Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
