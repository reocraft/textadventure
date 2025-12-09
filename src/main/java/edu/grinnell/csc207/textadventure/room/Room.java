package edu.grinnell.csc207.textadventure.room;

import java.util.*;

import edu.grinnell.csc207.textadventure.inventory.Inventory;
import edu.grinnell.csc207.textadventure.inventory.gamestate.GameState;
import edu.grinnell.csc207.textadventure.inventory.item.Item;

public abstract class Room {

    private final String name;
    private final String description;

    private final Map<String, Room> exits = new HashMap<>();
    private final Map<String, String> objects = new HashMap<>();
    private final Map<String, Item> items = new HashMap<>();

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
        if(items.containsKey(target.toLowerCase())) {
            System.out.printf("You looked at %s. And what are you gonna do with it? LOL\n", target);
        }
        else if (objects.containsKey(target.toLowerCase())) {
            System.out.printf("Wow is %s your imaginary friend? You wanna go say hi?\n", target);
        }
        else {
            System.out.printf("Don't see %s here. Well you have no friends afterall.\n", target);
        }
    }

    public void pickUp(Item item) {
        System.out.printf("You picked up %s.\n", item.getName());
        items.put(item.getName().toLowerCase(), item);
    }

    public void throwAway(Item item) {
        System.out.printf("You threw away %s,\n", item.getName());
        items.remove(item.getName().toLowerCase());
    }

}


    // protected String description;
    // protected Map<String, Room> exits = new HashMap<>();
    // protected Map<String, Item> items = new HashMap<>();

    // public Room(String description) {
    //     this.description = description;
    // }

    // public void addExit(String direction, Room room) {
    //     exits.put(direction.toLowerCase(), room);
    // }

    // public void enter(GameState state) {
    //     System.out.println(description);
    // }
    
    // public void go(GameState state, String dire) {
    //     dire = dire.toLowerCase();
    //     if (!exits.containsKey(dire)) {
    //         System.out.printf("You're too fat. You can't go to %s from here LOL\n", dire);
    //         return;
    //     }
    //     state.setCurrentRoom(exits.get(dire));
    //     state.getCurrentRoom().enter(state);
    // }

    // public void pickUp(GameState state, String itemName) {
    //     itemName = itemName.toLowerCase();
    //     if (!items.containsKey(itemName)) {
    //         System.out.printf("Item %s not found. Maybe go touch some grass if you want to get real things LOL\n", itemName);
    //         return;
    //     }
    //     state.getInventory().add(new Inventory());
    // }






//     protected String name;
//     protected Room north;
//     protected Room south;
//     protected Room east;
//     protected Room west;

//     protected List<Object> items;
//     protected Object phone;


//     public Room(String name) {
//         this.name = name;
//     }

//     public String getName() {
//         return name;
//     }

//     public Room Wait() {
//         System.out.println("You waited. And..?");
//         return this;
//     }

//     public Room go(String direction) {
//         if (north != null && direction.equals("north") || direction.equals("North")) {
//             System.out.println("You moved North.");
//             return north;
//         }
//         else if (south != null && direction.equals("south") || direction.equals("South")) {
//             System.out.println("You moved South.");
//             return south;
//         }
//         else if (east != null && direction.equals("east") || direction.equals("East")) {
//             System.out.println("You moved East.");
//             return east;
//         }
//         else if (west != null && direction.equals("west") || direction.equals("West")) {
//             System.out.println("You moved West.");
//             return west;
//         }
//         else {
//             System.out.println("Invalid direction. You got 4 choices. North, east, south, or west! Never eat soggy waffles!");
//             return this;
//         }
//     }

//     public Room talkTo(Object obj) {
//         System.out.println("There isn't anybody to talk to here.");
//         return this;
//     }

//     public Room pickUp() {
//         System.out.println("No items here.");
//         return this;
//     }

//     public Room use(Object obj) {
//         if (obj.equals(phone)) {
//             System.out.println("You used your phone. What are you gonna do with it?\nPlay more games? Go touch some grass.\nGame over!");
//             return this;
//             // Think of how to exit the game for scenarios like this where we want it to be game over.
//         }
//         else {
//             System.out.println("What is this rubbish? Throw it away.");
//             return this;
//         }
//     }

//     public Room attack(Object obj) {
//         System.out.println("Who are you going to attack here? You got no friends bruh");
//         return this;
//     }

//     public Room lookAt(Object obj) {
//         System.out.println("What are you looking at? You have to lock in bro");
//         return this;
//     }

// }

// class BedRoom extends Room {

//     protected Object mirror;
    
//     public BedRoom(Room north) {
//         super("Bedroom");
//         this.north = north; // Sets north room to be `north`
//         this.south = null;
//         this.east = null;
//         this.west = null;
//         this.north.south = this; // Set's `north` room's south to be this room
//     }

//     public BedRoom() {
//         super("Bedroom");
//         this.north = null;
//         this.south = null;
//         this.east = null;
//         this.west = null;
//     }

//     @Override
//     public Room pickUp() {
//         items.add(phone);
//         System.out.printf("You picked up a %s.\n", phone);
//         return this;
//     }

//     @Override
//     public Room lookAt(Object obj) {
//         if (obj.equals(mirror)) {
//             System.out.println("Look at you. Haven't showed in 3 weeks and your armpit stinks.\nGo take a shower!\nGame over!");
//             return this; // Exit game here;
//         }
//         else {
//             return this;
//         }
//     }



// class Hallway extends Room {
    
//     public Hallway(Room north, Room south, Room east, Room west) {
//         super("Hallway");
//         this.north = north;
//         this.south = south;
//         this.east = east;
//         this.west = west;
//         this.north.south = this;
//         this.south.north = this;
//         this.east.west = this;
//         this.west.east = this;
//     }

//     @Override
//     public Room lookAt(Object obj) {
//         System.out.println("What are you looking at? A ghost?\nOh right! You were already dead!\nGame over!");
//         return this;
//         // Exit game here
//     }


// }
