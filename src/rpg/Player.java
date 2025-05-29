package rpg;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private int level;
    private int hp;
    private Inventory inventory;

    public Player(String name_p, int level_p) {
        this.name = name_p;
        this.level = level_p;
        this.hp = 100;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setHp(int hp_p) {
        this.hp = hp_p;
    }

    public void levelUp() {
        level++;
        hp += 10;
    }
}
