package rpg;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private double weight;
    private int quantity;

    public Item(String name, double weight, int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalWeight() {
        return weight * quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void removeQuantity(int amount) {
        this.quantity -= amount;
        if (this.quantity < 0) this.quantity = 0;
    }

    @Override
    public String toString() {
        return name + " (x" + quantity + ", " + weight + "kg cada)";
    }
}
