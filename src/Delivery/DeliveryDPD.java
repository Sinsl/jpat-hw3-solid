package Delivery;

import Products.DataProductQuantity;

import java.util.ArrayList;

public class DeliveryDPD extends Delivery implements DeliveryDPDInterface{
    @Override
    public void stepDelivery(ArrayList<DataProductQuantity> listProduct) {
        super.registrationProductsInDelivery(listProduct);
        this.makingDeclaration();
        this.searchTransport();
        this.sendProducts();
        this.receivedOfficeDPD();
        super.doneDelivery();
    }

    @Override
    public void makingDeclaration() {
        System.out.println("Оформлена декларация на груз");
    }

    @Override
    public void searchTransport() {
        System.out.println("Найден транспорт для отправке в составном грузе");
    }

    @Override
    public void sendProducts() {
        System.out.println("Товары отправлены в страну назначения");
    }

    @Override
    public void receivedOfficeDPD() {
        System.out.println("Товары приняты офисом DPD в стране назначения");
    }
}
