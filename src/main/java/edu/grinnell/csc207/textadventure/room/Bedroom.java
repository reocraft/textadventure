package edu.grinnell.csc207.textadventure.room;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

public class Bedroom extends Room {

    public Bedroom() {
        super("Bedroom", "The place where your stinky a$$ sleeps every single day.");
        addObject("hair", "Ugh it stinks!");
    }

    @Override
    public void pickUp(String itemName) {
        Item item = items.get(itemName.toLowerCase());
        if (item != null) {
            System.out.printf("You picked up %s.\n", item.getName());
        }
    }

    @Override
    public Item throwAway(String itemName) {
        return items.remove(itemName.toLowerCase());
    }

    @Override
    public String getObject(String objName) {
        return objects.get(objName.toLowerCase());
    }

    @Override
    public void removeObject(String objName) {
        objects.remove(objName.toLowerCase());
    }
}
