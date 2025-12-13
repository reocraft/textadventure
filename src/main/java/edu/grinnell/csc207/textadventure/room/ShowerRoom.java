package edu.grinnell.csc207.textadventure.room;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

public class ShowerRoom extends Room {

    public ShowerRoom() {
        super("Shower Room", "A steamy bathroom. The mirror shows you haven't showered in weeks!");
    }

    @Override
    protected boolean checkGameOver() {
        System.out.println("\nUgh oh. I think you have entered the shower room.");
        System.out.println("CLICK! The doors lock. I guess you can't leave until you take a shower!");
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

