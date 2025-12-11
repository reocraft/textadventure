package edu.grinnell.csc207.textadventure.parser;

/**
 * Represents a parsed command consisting of an action verb and an optional argument.
 * Commands are created by the Parser from user input strings.
 */
public class Command {
    private final String action;
    private final String argument;

    /**
     * Constructs a new Command with the given action and argument.
     * The action will be converted to lowercase.
     * 
     * @param action the action verb (e.g., "go", "look", "pickup")
     * @param argument the argument for the action (e.g., "north", "mirror"), 
     *                 or null if the action takes no argument
     */
    public Command(String action, String argument) {
        this.action = action.toLowerCase();
        if (argument == null) {
            this.argument = null;
        } else {
            this.argument = argument;
        }
    }

    /**
     * Gets the action verb of this command.
     * @return the action (always lowercase)
     */
    public String getAction() {
        return action;
    }

    /**
     * Gets the argument of this command.
     * @return the argument, or null if this command has no argument
     */
    public String getArgument() {
        return argument;
    }

    /**
     * Returns a string representation of this command.
     * @return the action and argument as a space-separated string, 
     *         or just the action if there is no argument
     */
    @Override
    public String toString() {
        if (argument == null) {
            return action;
        } else {
            return action + " " + argument;
        }
    }
}
