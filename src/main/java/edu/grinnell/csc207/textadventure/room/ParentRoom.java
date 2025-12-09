package edu.grinnell.csc207.textadventure.room;

public class ParentRoom extends Room {
    public ParentRoom() {
        super("Parent's Room", "You don't want to wake them up at night!");
        addObject("Parents", "If you're caught by them at night, they're gonna kill you. Literally.");
    }
}
