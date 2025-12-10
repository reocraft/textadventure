package edu.grinnell.csc207.textadventure.room;

import java.util.*;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

public abstract class Room {

    private final String name;
    private final String description;

    private final Map<String, Room> exits = new HashMap<>();
    protected final Map<String, String> objects = new HashMap<>();
    protected final Map<String, Item> items = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void enter() {
        System.out.printf("You entered the %s.\n", name);
        System.out.println(description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, Room destination) {
        exits.put(direction.toLowerCase(), destination);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public void addObject(String name, String talkResponse) {
        objects.put(name.toLowerCase(), talkResponse);
    }

    public void addItem(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public void talkTo(String target) {
        String response = objects.get(target.toLowerCase());
        if (response == null) {
            System.out.printf("There is no %s to talk to.\n", target);
        } else {
            System.out.println(response);
        }
    }

    public void attack(String target) {
        if (objects.containsKey(target.toLowerCase())) {
            System.out.printf("You attacked %s.\n Wow you did something for once lol.\n", target);
        } else {
            System.out.printf("There is no %s to attack bro.\n", target);
        }
    }

    public void lookAt(String target) {
        Item item = items.get(target.toLowerCase());
        if (item != null) {
            System.out.println(item.getDescription());
        } else if (objects.containsKey(target.toLowerCase())) {
            System.out.printf("Wow is %s your imaginary friend? You wanna go say hi?\n", target);
        } else {
            System.out.printf("Don't see %s here. Well you have no friends afterall.\n", target);
        }
    }

    public abstract void pickUp(String itemName);

    public abstract Item throwAway(String itemName);

    public abstract String getObject(String objName);
    
    public abstract void removeObject(String objName);

}
