package edu.grinnell.csc207.textadventure.parser;
import java.util.Scanner;

public class Parser {
    private final Scanner in;

    public Parser() {
        this.in = new Scanner(System.in);
    }

    public static Command parse(String input) {

        if (input.isEmpty()) {
            return new Command("", null);
        }

        if (input.equals("wait".toLowerCase())) {
            return new Command("wait", null);
        }
        if (input.equals("inventory".toLowerCase())) {
            return new Command("inventory", null);
        }
        if (input.equals("look".toLowerCase())) {
            return new Command("look", null);
        }

        if (input.startsWith("go ".toLowerCase())) {
            String direction = input.substring(3).trim();
            return new Command("go", direction);
        }

        if (input.startsWith("look at ".toLowerCase())) {
            String target = input.substring(8).trim();
            return new Command("look at", target);
        }

        if (input.startsWith("talk to ".toLowerCase())) {
            String target = input.substring(8).trim();
            return new Command("talk to", target);
        }

        if (input.startsWith("pick up ".toLowerCase())) {
            String target = input.substring(8).trim();
            return new Command("pick up", target);
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
