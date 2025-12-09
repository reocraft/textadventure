package edu.grinnell.csc207.textadventure.inventory.gamestate;
import edu.grinnell.csc207.textadventure.inventory.Inventory;
import edu.grinnell.csc207.textadventure.room.Room;

public class GameState {
    private Room currentRoom;
    private final Inventory inventory;

    public GameState() {
        this.inventory = new Inventory();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
