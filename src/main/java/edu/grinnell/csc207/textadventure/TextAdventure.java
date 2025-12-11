package edu.grinnell.csc207.textadventure;

import edu.grinnell.csc207.textadventure.inventory.Inventory;
import edu.grinnell.csc207.textadventure.inventory.item.Item;
import edu.grinnell.csc207.textadventure.inventory.item.GameOverItem;
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
        Room showerRoom = new ShowerRoom();
        Room trapRoom = new TrapRoom();

        
        Item mirror = new GameOverItem("mirror", "You can look at yourself.",
            "Look at you. You look so nasty and stinky! Go take a shower!");
        Item painting = new Item("painting", "It illustrates your dead body...?");
        // We add objects in the constructor but items here
        

        bedroom.addExit("north", hallway);
        hallway.addExit("south", bedroom);
        hallway.addExit("west", parentroom);
        hallway.addExit("north", showerRoom);
        hallway.addExit("east", trapRoom);
        trapRoom.addExit("west", hallway);
        showerRoom.addExit("south", hallway);
        parentroom.addExit("east", hallway);

        bedroom.addItem(mirror);
        hallway.addItem(painting);


        Room current = bedroom;
        boolean gameOver = current.enter();
        if (gameOver) {
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            while(true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("quit") || input.equals("exit")) {
                break; // Allow user to exit game when they want to.
            }

            Command cmd = Parser.parse(input);

            switch (cmd.getAction()) {
                case "wait":
                    gameOver = current.onWait();
                    if (gameOver) {
                        return;
                    }
                    System.out.println("You waited. Nothing happens... Duh?");
                    break;
                
                case "go":
                    if (cmd.getArgument() == null) {
                        System.out.println("There's nowhere to go. Maybe go look at your E-girl LOL.");
                    } else {
                        Room next = current.getExit(cmd.getArgument());
                        if (next == null) {
                            System.out.printf("You can't go to %s!\n", cmd.getArgument());
                        } else {
                            current = next;
                            gameOver = current.enter();
                            if (gameOver) {
                                return;
                            }
                        }
                    }
                    break;

                case "look":
                    if (cmd.getArgument() == null) {
                        System.out.println(current.getDescription());
                        String itemsDesc = current.getItemsDescription();
                        if (!itemsDesc.isEmpty()) {
                            System.out.println(itemsDesc);
                        }
                    } else {
                        gameOver = current.lookAt(cmd.getArgument());
                        if (gameOver) {
                            return;
                        }
                    }
                    break;

                case "talk":
                    if (cmd.getArgument() == null) {
                        System.out.println("YOU HAVE NO FRIENDS WHO ARE YOU GONNA TALK TO LOL");
                    } else {
                        current.talkTo(cmd.getArgument());
                    }
                    break;

                case "pickup":
                case "pick up":
                    if (cmd.getArgument() == null) {
                        System.out.println("Watchu tryna pick up stoopid?");
                    } else {
                        Item item = current.throwAway(cmd.getArgument());
                        if (item == null) {
                            System.out.printf("There is no %s here.\n", cmd.getArgument());
                        } else {
                            inv.add(item);
                            // Check if item causes game over
                            if (item.causesGameOver()) {
                                item.onGameOver();
                                return;
                            }
                        }
                    }
                    break;

                case "inventory":
                    inv.list();
                    break;

                case "attack":
                    if (cmd.getArgument() == null) {
                        System.out.println("Watchu gonna attack bro?");
                    } else {
                        String obj = current.getObject(cmd.getArgument());
                        if (obj == null) {
                            System.out.printf("There is no %s here LOL\n", cmd.getArgument());
                        } else {
                            System.out.printf("You attacked the %s!", obj);
                            System.out.println("You're so weak! You're cooked LOL");
                            current.removeObject(obj);
                        }
                    }
                    break;

                default:
                    System.out.println("What u saying dawg?");
                    break;
            }
            }
        }
    }
}
