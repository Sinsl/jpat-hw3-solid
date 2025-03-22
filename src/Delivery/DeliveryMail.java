package Delivery;

import Products.DataProductQuantity;

import java.util.ArrayList;

public class DeliveryMail extends Delivery implements DeliveryMailInterface{
    @Override
    public void stepDelivery(ArrayList<DataProductQuantity> listProduct) {
        super.registrationProductsInDelivery(listProduct);
        this.searchСounterpartyInDestinationCountry();
        this.searchAirTransport();
        this.makingDeclaration();
        this.sendProducts();
        this.receivedСounterpartyInDestinationCountry();
        super.doneDelivery();
    }

    @Override
    public void searchСounterpartyInDestinationCountry() {
        System.out.println("Найден контрагент доставки в стране назначения");
    }

    @Override
    public void searchAirTransport() {
        System.out.println("Найден авиа-рейс для отправки");
    }

    @Override
    public void makingDeclaration() {
        System.out.println("Оформлена декларация на товары");
    }

    @Override
    public void sendProducts() {
        System.out.println("Товары отправлены авиа-рейсом");
    }

    @Override
    public void receivedСounterpartyInDestinationCountry() {
        System.out.println("Товары приняты контрагентом доставки в стране назначения");
    }
}
