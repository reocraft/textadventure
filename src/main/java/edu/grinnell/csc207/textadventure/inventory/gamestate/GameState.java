package edu.grinnell.csc207.textadventure.inventory.gamestate;
import edu.grinnell.csc207.textadventure.inventory.Inventory;
import edu.grinnell.csc207.textadventure.room.Room;

/**
 * Represents the current state of the game, including the player's
 * current location and inventory.
 */
public class GameState {
    private Room currentRoom;
    private final Inventory inventory;

    /**
     * Constructs a new GameState with an empty inventory.
     */
    public GameState() {
        this.inventory = new Inventory();
    }

    /**
     * Gets the room the player is currently in.
     * @return the current room, or null if not set
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the room the player is currently in.
     * @param room the room to set as the current room
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Gets the player's inventory.
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
