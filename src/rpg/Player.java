package rpg;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private int level;
    private Inventory inventory;

    public Player(String name_p, int level_p) {
        this.name = name_p;
        this.level = level_p;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void levelUp() {
        level++;
    }
}
