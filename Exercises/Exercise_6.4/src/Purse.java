import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a purse in which you can store coins.
 *
 * @author Severin Kaderli
 */
public class Purse {
    /**
     * The list to keep track of the coins
     */
    List<Coin> purse;

    /**
     * Create a new empty purse.
     */
    public Purse() {
        this.purse = new ArrayList<Coin>();
    }

    /**
     * Create a new purse and fill it with coins.
     *
     * @param coins The coins which should be added
     */
    public Purse(Coin... coins) {
        this();
        Collections.addAll(this.purse, coins);
    }

    /**
     * Adds a coin to the purse.
     *
     * @param coin The coin to add
     */
    public void addCoin(Coin coin) {
        purse.add(coin);
    }

    /**
     * Returns the purse.
     *
     * @return The purse
     */
    public List<Coin> getPurse() {
        return this.purse;
    }

    /**
     * Returns the value of the coins in cents.
     *
     * @return The value in cents
     */
    public int getValue() {
        int value = 0;

        for(int i = 0; i < this.purse.size(); i++) {
            switch(this.purse.get(0)) {
                case QUARTER:
                    value += 25;
                    break;
                case DIME:
                    value += 10;
                    break;
                case NICKEL:
                    value += 5;
                    break;
                case PENNY:
                    value += 1;
                    break;
            }
        }

        return value;
    }

    /**
     * Checks whether two purses have the same value.
     *
     * @param other The other purse to check with
     * @return True if they have the same value, false otherwise
     */
    public boolean sameValue(Purse other) {
        return this.getValue() == other.getValue();
    }

    /**
     * Checks whether two purses have the same coins. The order is not
     * important.
     *
     * @param other The other purse to check with
     * @return True if they have the same coins, false otherwise
     */
    public boolean sameCoins(Purse other) {
        Collections.sort(this.getPurse());
        Collections.sort(other.getPurse());
        return this.getPurse().equals(other.getPurse());
    }

    /**
     * Transfers the coins of this purse to another one.
     *
     * @param other The purse where the coins will be transferred to
     */
    public void transferTo(Purse other) {
        other.getPurse().addAll(this.getPurse());
    }

    /**
     * Transfers the coins of another purse to this one.
     *
     * @param other The purse where the coins will be transferred from
     */
    public void transferFrom(Purse other) {
        this.purse.addAll(other.getPurse());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.getPurse().size(); i++) {
            sb.append(this.getPurse().get(i).name());
            if(i != this.getPurse().size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
