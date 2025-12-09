package edu.grinnell.csc207.textadventure.inventory.item;

public class Item {

    private final String name;
    private final String description;

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
}
