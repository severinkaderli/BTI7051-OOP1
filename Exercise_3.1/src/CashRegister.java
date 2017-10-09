import java.math.BigDecimal;

/**
 *
 */
public class CashRegister {
    /**
     * Value of a quarter
     */
    public static final BigDecimal QUARTER_VALUE = new BigDecimal("0.25");

    /**
     * Value of a dime
     */
    public static final BigDecimal DIME_VALUE = new BigDecimal("0.1");

    /**
     * Value of a nickel
     */
    public static final BigDecimal NICKEL_VALUE = new BigDecimal("0.05");

    /**
     * The purchase amount
     */
    private BigDecimal purchase;

    /**
     * The amount that was entered for payment.
     */
    private BigDecimal payment;

    /**
     * Create a new instance of CashRegister
     */
    public CashRegister() {
        this.purchase = new BigDecimal(0);
        this.payment = new BigDecimal(0);
    }

    /**
     * Record a new purchase and add it to the total.
     *
     * @param amount The amount of the purchase
     */
    public void recordPurchase(String amount) {
        this.purchase = this.purchase.add(new BigDecimal(amount));
    }

    /**
     * Enter a payment in different values.
     *
     * @param numberOfDollars The number of dollars
     * @param numberOfQuarters The number of quarters
     * @param numberOfDimes The number of dimes
     * @param numberOfNickels The number of nickels
     */
    public void enterPayment(int numberOfDollars, int numberOfQuarters, int numberOfDimes, int numberOfNickels) {
        this.enterDollars(numberOfDollars);
        this.enterQuarters(numberOfQuarters);
        this.enterDimes(numberOfDimes);
        this.enterNickels(numberOfNickels);
    }

    /**
     * Enter a specific amount of dollars for the payment.
     *
     * @param numberOfDollars The number of dollars
     */
    public void enterDollars(int numberOfDollars) {
        this.payment = this.payment.add(new BigDecimal(numberOfDollars));
    }

    /**
     * Enter a specific number of quarters for the payment.
     *
     * @param numberOfQuarters The number of quarters
     */
    public void enterQuarters(int numberOfQuarters) {
        this.payment = this.payment.add(QUARTER_VALUE.multiply(new BigDecimal(numberOfQuarters)));
    }

    /**
     * Enter a specific amount of dimes for the payment.
     *
     * @param numberOfDimes The number of dimes
     */
    public void enterDimes(int numberOfDimes) {
        this.payment = this.payment.add(DIME_VALUE.multiply(new BigDecimal(numberOfDimes)));
    }

    /**
     * Enter a specific amount of nickels for the payment.
     *
     * @param numberOfNickels The number of nickels
     */
    public void enterNickels(int numberOfNickels) {
        this.payment = this.payment.add(NICKEL_VALUE.multiply(new BigDecimal(numberOfNickels)));
    }

    /**
     * Returns the change for this payment and resets the purchase and payment
     * amount to 0.
     */
    public double giveChange() {
        BigDecimal change = this.payment.subtract(this.purchase);
        this.purchase = BigDecimal.ZERO;
        this.payment = BigDecimal.ZERO;
        return change.doubleValue();
    }
}