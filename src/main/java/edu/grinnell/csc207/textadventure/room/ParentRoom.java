package edu.grinnell.csc207.textadventure.room;

import java.util.HashMap;
import java.util.Map;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

public class ParentRoom extends Room {

    private final Map<String, Item> mapItems = new HashMap<>();
    private final Map<String, String> mapObjects = new HashMap<>();

    public ParentRoom() {
        super("Parent's Room", "You don't want to wake them up at night!");
        addObject("Parents", "If you're caught by them at night, they're gonna kill you. Literally.");
    }

    @Override
    public void addObject(String name, String talkResponse) {
        mapObjects.put(name.toLowerCase(), talkResponse);
    }

    @Override
    public void addItem(Item item) {
        mapItems.put(item.getName().toLowerCase(), item);
    }

    public String getObject(String objName) {
        return mapObjects.remove(objName);
    }

    public void removeObject(String objName) {
        mapObjects.remove(objName);
    }

    @Override
    public void pickUp(String itemName) {
        Item item = mapItems.get(itemName);
        System.out.printf("You picked up %s.\n", item.getName());
        items.put(item.getName().toLowerCase(), item);
    }

    @Override
    public Item throwAway(String itemName) {
        Item item = mapItems.get(itemName);
        // System.out.printf("You threw away %s,\n", item.getName());
        items.remove(item.getName().toLowerCase());
        return item;
    }
}
