package edu.grinnell.csc207.textadventure.parser;

public class Command {
    private final String action;
    private final String argument;

    public Command(String action, String argument) {
        this.action = action.toLowerCase();
        if (argument == null) {
            this.argument = null;
        } else {
            this.argument = argument;
        }
    }

    public String getAction() {
        return action;
    }

    public String getArgument() {
        return argument;
    }

    public String toString() {
        if (argument == null) {
            return action;
        } else {
            return action + " " + argument;
        }
    }
}
