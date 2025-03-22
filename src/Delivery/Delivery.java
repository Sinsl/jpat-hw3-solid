package Delivery;

import Products.DataProductQuantity;

import java.util.ArrayList;

public abstract class Delivery {
    private ArrayList<DataProductQuantity> listProduct = new ArrayList<>();

    public void registrationProductsInDelivery(ArrayList<DataProductQuantity> listProduct){
        this.listProduct.addAll(listProduct);
        System.out.println("Товар передан в доставку");
    }

    public abstract void stepDelivery(ArrayList<DataProductQuantity> listProduct);

    public void doneDelivery() {
        System.out.println("Товар передан покупателю");
        this.listProduct.clear();
    };
}
