package rpg;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private int quantidade;

    public Item(String name, double weight, int quantidade) {
        this.name = name;
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantidade;
    }
    public void addQuantity(int amount) {
        this.quantidade += amount;
    }

    public void removeQuantity(int amount) {
        this.quantidade -= amount;
        if (this.quantidade < 0) this.quantidade = 0;
    }

    @Override
    public String toString() {
        return name + " (x" + quantidade;
    }
}
