package edu.grinnell.csc207.textadventure.inventory;
import edu.grinnell.csc207.textadventure.inventory.item.Item;
import java.util.*;

/**
 * Represents the player's inventory, which can hold items collected during the game.
 */
public class Inventory {
    
    private final Map<String, Item> items;

    /**
     * Constructs an empty inventory.
     */
    public Inventory() {
        this.items = new HashMap<>();
    }

    /**
     * Adds an item to the inventory.
     * @param item the item to add
     */
    public void add(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    /**
     * Checks if the inventory contains an item with the given name.
     * @param itemName the name of the item to check for
     * @return true if the inventory contains the item, false otherwise
     */
    public boolean has(String itemName) {
        return items.containsKey(itemName.toLowerCase());
    }

    /**
     * Gets an item from the inventory by name.
     * @param itemName the name of the item to retrieve
     * @return the item, or null if the item is not in the inventory
     */
    public Item get(String itemName) {
        return items.get(itemName.toLowerCase());
    }

    /**
     * Removes and returns an item from the inventory.
     * @param itemName the name of the item to remove
     * @return the removed item, or null if the item was not in the inventory
     */
    public Item remove(String itemName) {
        return items.remove(itemName.toLowerCase());
    }

    /**
     * Lists all items in the inventory to the console.
     * Displays "Your inventory is empty." if there are no items.
     */
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
