package edu.grinnell.csc207.textadventure.room;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

public class Hallway extends Room {

    public Hallway() {
        super("Hallway", "A narrow hallway. Hope you don't run into any ghosts!");
        addObject("painting", "It's a skeleton of your body. Wait... what?");
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
