package edu.grinnell.csc207.textadventure;

import edu.grinnell.csc207.textadventure.inventory.Inventory;
import edu.grinnell.csc207.textadventure.parser.Command;
import edu.grinnell.csc207.textadventure.parser.Parser;
import edu.grinnell.csc207.textadventure.room.*;

import java.util.Scanner;

public class TextAdventure {

    public static void main(String[] args) {
        Inventory inv = new Inventory();

        Room bedroom = new Bedroom();
        Room hallway = new Hallway();
        Room parentroom = new ParentRoom();

        bedroom.addExit("north", hallway);
        hallway.addExit("south", bedroom);
        hallway.addExit("west", parentroom);
        parentroom.addExit("east", hallway);

        Room current = bedroom;
        current.enter();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.toLowerCase().equals("quit") || input.toLowerCase().equals("exit")) {
                break; // Allow user to exit game when they want to.
            }
        }

    }


}
