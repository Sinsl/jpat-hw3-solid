package Delivery;

import Products.DataProductQuantity;

import java.util.ArrayList;

public class DeliverySDEK extends Delivery implements DeliverySDEKInterface{
    @Override
    public void stepDelivery(ArrayList<DataProductQuantity> listProduct) {
        super.registrationProductsInDelivery(listProduct);
        this.searchTransport();
        this.sendProducts();
        this.receivedLocalOffice();
        super.doneDelivery();
    }

    @Override
    public void searchTransport() {
        System.out.println("Найден транспорт для доставки в другой регион");
    }

    @Override
    public void sendProducts() {
        System.out.println("Товар отправлен");
    }

    @Override
    public void receivedLocalOffice() {
        System.out.println("Товар принят офисом SDEK в месте назначения");
    }
}
