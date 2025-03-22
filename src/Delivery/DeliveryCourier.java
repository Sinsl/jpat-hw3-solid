package Delivery;

import Products.DataProductQuantity;

import java.util.ArrayList;

public class DeliveryCourier extends Delivery implements DeliveryCourierInterface{

    @Override
    public void stepDelivery(ArrayList<DataProductQuantity> listProduct) {
        super.registrationProductsInDelivery(listProduct);
        this.sentToСourier();
        super.doneDelivery();
    }

    @Override
    public void sentToСourier() {
        System.out.println("Товар передан курьеру для доставки");
    }
}
