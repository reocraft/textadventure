package edu.grinnell.csc207.textadventure.parser;

public class Command {
    private final String verb;
    private final String argument;

    public Command(String verb, String argument) {
        this.verb = verb.toLowerCase();
        if (argument == null) {
            this.argument = null;
        } else {
            this.argument = argument;
        }
    }

    public String getVerb() {
        return verb;
    }

    public String getArgument() {
        return argument;
    }

    public String toString() {
        if (argument == null) {
            return verb;
        } else {
            return verb + " " + argument;
        }
    }
}
