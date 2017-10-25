import java.util.Random;

/**
 * This class simulates a roulette game where you always
 * set on black.
 *
 * @author Severin Kaderli
 */
public class RoulettePlayer {
    /**
     * Total number of tries so far.
     */
    private int tries;

    /**
     * The number of wins so far.
     */
    private int wins;

    /**
     * The current balance
     */
    private int balance;

    /**
     * Returns the current number of tries.
     *
     * @return The number of tries
     */
    public int getTries() {
        return this.tries;
    }

    /**
     * Returns the current number of wins.
     *
     * @return The number of wins
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Returns the win probability for the current results.
     *
     * @return The probability
     */
    public double getWinProbability() {
        return (double) this.getWins() / this.getTries();
    }

    /**
     * Creates a new simulator and sets default values.
     */
    public RoulettePlayer() {
        this.tries = 0;
        this.wins = 0;
    }

    /**
     * Sets the given amount on black and checks if you won.
     * Adjusts the balance based on the outcome.
     *
     * @param amount The bid amount
     * @return true if won, false otherwise
     */
    public boolean playBlack(int amount) {
        Random random = new Random();

        // Check if we won with a 18/37 change
        if (random.nextInt(37) < 18) {
            this.balance += 2 * amount;
            return true;
        } else {
            this.balance -= amount;
            return false;
        }
    }

    /**
     * Play the strategy until we won or ran out of money. The
     * bid amount doubles after each loss.
     */
    public void playStrategy() {
        int bidAmount = 1;

        while (!playBlack(bidAmount) && this.balance > 0) {
            bidAmount *= 2;
        }
    }

    /**
     * Visit the casino with a specific balance and play the
     * the strategy until we reach the goal balance or run out
     * of money.
     *
     * @param startBalance The starting balance
     * @param endBalance   The goal balance
     */
    public void visitCasino(int startBalance, int endBalance) {
        this.tries++;
        this.balance = startBalance;

        // Play until we lose everything or reach our goal
        while (this.balance > 0 && this.balance < endBalance) {
            this.playStrategy();
        }

        if (this.balance > 0) {
            this.wins++;
        }
    }
}
