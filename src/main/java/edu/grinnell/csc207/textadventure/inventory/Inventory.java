package edu.grinnell.csc207.textadventure.inventory;
import edu.grinnell.csc207.textadventure.inventory.item.Item;
import java.util.*;


public class Inventory {
    
    private final Map<String, Item> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void add(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public boolean has(String itemName) {
        return items.containsKey(itemName.toLowerCase());
    }

    public Item get(String itemName) {
        return items.get(itemName.toLowerCase());
    }

    public Item remove(String itemName) {
        return items.remove(itemName.toLowerCase());
    }

    public void list() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : items.values()) {
                System.out.println("- " + item.getName());
            }
        }
    }

}
