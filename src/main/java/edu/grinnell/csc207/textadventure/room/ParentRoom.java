package edu.grinnell.csc207.textadventure.room;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

public class ParentRoom extends Room {

    public ParentRoom() {
        super("Parent's Room", "You don't want to wake them up at night!");
        addObject("Parents", "If you're caught by them at night, they're gonna kill you. Literally.");
    }

    @Override
    protected boolean checkGameOver() {
        System.out.println("\nYour parents wake up and catch you!");
        System.out.println("They're furious! You're grounded for life!");
        System.out.println("\n=== GAME OVER ===");
        return true;
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
