package edu.grinnell.csc207.textadventure.parser;

/**
 * Parses user input strings and converts them into Command objects
 * that can be executed by the game.
 */
public class Parser {
    /**
     * Parses a user input string and converts it into a Command object.
     * Recognizes commands such as "go", "look", "look at", "talk to", 
     * "pick up", "wait", "inventory", and generic verb-noun commands.
     * 
     * @param input the user input string to parse (should be lowercase)
     * @return a Command object representing the parsed command
     */
    public static Command parse(String input) {

        if (input.isEmpty()) {
            return new Command("", null);
        }

        if (input.equals("wait")) {
            return new Command("wait", null);
        }
        if (input.equals("inventory")) {
            return new Command("inventory", null);
        }
        if (input.equals("look")) {
            return new Command("look", null);
        }

        if (input.startsWith("go ")) {
            String direction = input.substring(3).trim();
            return new Command("go", direction);
        }

        if (input.startsWith("look at ")) {
            String target = input.substring(8).trim();
            return new Command("look", target);
        }

        if (input.startsWith("talk to ")) {
            String target = input.substring(8).trim();
            return new Command("talk", target);
        }

        if (input.startsWith("pick up ")) {
            String target = input.substring(8).trim();
            return new Command("pickup", target);
        }

        String[] phrase = input.split("\\s", 2);
        String verb = phrase[0];
        if (phrase.length > 1) {
            return new Command(verb, phrase[1]);
        } else {
            return new Command(verb, null);
        }
    }
}
