package edu.grinnell.csc207.textadventure.inventory.item;

/**
 * An item that causes the game to end when picked up.
 */
public class GameOverItem extends Item {
    private final String gameOverMessage;

    /**
     * Constructs a new GameOverItem that will trigger game over when picked up.
     * @param name the name of the item
     * @param description the description of the item
     * @param gameOverMessage the message to display when the item causes game over
     */
    public GameOverItem(String name, String description, String gameOverMessage) {
        super(name, description);
        this.gameOverMessage = gameOverMessage;
    }

    /**
     * Returns true since this item always causes game over when picked up.
     * @return true
     */
    @Override
    public boolean causesGameOver() {
        return true;
    }

    /**
     * Displays the game over message when this item is picked up.
     */
    @Override
    public void onGameOver() {
        System.out.println(gameOverMessage);
        System.out.println("\n=== GAME OVER ===");
    }
}

