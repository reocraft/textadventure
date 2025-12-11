package edu.grinnell.csc207.textadventure.room;

import java.util.*;

import edu.grinnell.csc207.textadventure.inventory.item.Item;

/**
 * Represents a room in the text adventure game.
 * Rooms can contain items, objects, and exits to other rooms.
 * Subclasses must implement methods for managing items and objects.
 */
public abstract class Room {

    private final String name;
    private final String description;

    private final Map<String, Room> exits = new HashMap<>();
    protected final Map<String, String> objects = new HashMap<>();
    protected final Map<String, Item> items = new HashMap<>();

    /**
     * Constructs a new Room with the given name and description.
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Called when the player enters this room. Displays the room name,
     * description, and any items present. Checks for game over conditions.
     * @return true if game over should occur, false otherwise
     */
    public boolean enter() {
        System.out.printf("You entered the %s.\n", name);
        System.out.println(description);
        String itemsDesc = getItemsDescription();
        if (!itemsDesc.isEmpty()) {
            System.out.println(itemsDesc);
        }
        return checkGameOver();
    }

    /**
     * Override this method in subclasses to trigger game over conditions.
     * @return true if game over should occur, false otherwise
     */
    protected boolean checkGameOver() {
        return false;
    }

    /**
     * Called when the player uses the "wait" command in this room.
     * Override this method in subclasses to add special behavior.
     * @return true if game over should occur, false otherwise
     */
    public boolean onWait() {
        return false;
    }

    /**
     * Gets the name of this room.
     * @return the room name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of this room.
     * @return the room description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Adds an exit from this room to another room in the given direction.
     * @param direction the direction of the exit (e.g., "north", "south")
     * @param destination the room that the exit leads to
     */
    public void addExit(String direction, Room destination) {
        exits.put(direction.toLowerCase(), destination);
    }

    /**
     * Gets the room that an exit in the given direction leads to.
     * @param direction the direction to check
     * @return the destination room, or null if no exit exists in that direction
     */
    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    /**
     * Adds an object to this room that can be talked to.
     * @param name the name of the object
     * @param talkResponse the message displayed when talking to this object
     */
    public void addObject(String name, String talkResponse) {
        objects.put(name.toLowerCase(), talkResponse);
    }

    /**
     * Adds an item to this room that can be picked up.
     * @param item the item to add to the room
     */
    public void addItem(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    /**
     * Attempts to talk to an object in this room.
     * @param target the name of the object to talk to
     */
    public void talkTo(String target) {
        String response = objects.get(target.toLowerCase());
        if (response == null) {
            System.out.printf("There is no %s to talk to.\n", target);
        } else {
            System.out.println(response);
        }
    }

    /**
     * Attempts to attack an object in this room.
     * @param target the name of the object to attack
     */
    public void attack(String target) {
        if (objects.containsKey(target.toLowerCase())) {
            System.out.printf("You attacked %s.\n Wow you did something for once lol.\n", target);
        } else {
            System.out.printf("There is no %s to attack bro.\n", target);
        }
    }

    /**
     * Looks at a target in the room.
     * @param target the name of the item or object to look at
     * @return true if game over should occur, false otherwise
     */
    public boolean lookAt(String target) {
        Item item = items.get(target.toLowerCase());
        if (item != null) {
            System.out.println(item.getDescription());
        } else if (objects.containsKey(target.toLowerCase())) {
            System.out.printf("Wow is %s your imaginary friend? You wanna go say hi?\n", target);
        } else {
            System.out.printf("Don't see %s here. Well you have no friends afterall.\n", target);
        }
        return false;
    }

    /**
     * Returns a list of items in this room.
     * @return a string describing the items, or empty string if no items
     */
    public String getItemsDescription() {
        if (items.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("Items here: ");
        boolean first = true;
        for (Item item : items.values()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(item.getName());
            first = false;
        }
        sb.append(".");
        return sb.toString();
    }

    /**
     * Attempts to pick up an item from this room by name.
     * Subclasses should implement this to handle item pickup logic.
     * @param itemName the name of the item to pick up
     */
    public abstract void pickUp(String itemName);

    /**
     * Removes and returns an item from this room.
     * Subclasses should implement this to remove the item from the room's item collection.
     * @param itemName the name of the item to remove
     * @return the removed item, or null if the item doesn't exist
     */
    public abstract Item throwAway(String itemName);

    /**
     * Gets an object in this room by name.
     * Subclasses should implement this to retrieve objects from the room.
     * @param objName the name of the object to retrieve
     * @return the object's talk response string, or null if the object doesn't exist
     */
    public abstract String getObject(String objName);
    
    /**
     * Removes an object from this room.
     * Subclasses should implement this to remove objects from the room.
     * @param objName the name of the object to remove
     */
    public abstract void removeObject(String objName);

}
