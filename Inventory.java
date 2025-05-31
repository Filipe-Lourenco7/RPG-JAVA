package rpg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double weight, int quantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.addQuantity(quantity);
                return;
            }
        }
        items.add(new Item(name, weight, quantity));
    }

    public void removeItem(String name, int quantity) {
        items.removeIf(item -> {
            if (item.getName().equalsIgnoreCase(name)) {
                item.removeQuantity(quantity);
                return item.getQuantity() == 0;
            }
            return false;
        });
    }

    public double getTotalWeight() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotalWeight();
        }
        return total;
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}