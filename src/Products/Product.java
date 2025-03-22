package Products;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String manufacturer;
    private double price = 0.0;

    public Product(String name, String manufacturer) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.manufacturer = manufacturer;
    }
    public Product(String name, String manufacturer, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public  String toString() {
        return this.manufacturer + " " + this.name + ", price - " + this.price;
    }
}
