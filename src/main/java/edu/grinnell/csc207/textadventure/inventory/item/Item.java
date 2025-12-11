package edu.grinnell.csc207.textadventure.inventory.item;

/**
 * Represents an item that can be found in rooms and collected by the player.
 * Items have a name and description, and can optionally trigger game over when picked up.
 */
public class Item {

    private final String name;
    private final String description;

    /**
     * Constructs a new Item with the given name and description.
     * @param name the name of the item
     * @param description the description of the item
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use() {
        System.out.println("You can't use that item by itself.");
        // We have to add subclasses of Item that override use which does return something.
    }

    /**
     * Override this method in subclasses to trigger game over conditions when picked up.
     * @return true if picking up this item causes game over, false otherwise
     */
    public boolean causesGameOver() {
        return false;
    }

    /**
     * Called when this item causes a game over. Override to customize the message.
     */
    public void onGameOver() {
        System.out.println("\n=== GAME OVER ===");
    }
}
