public class CashRegisterTester {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        register.recordPurchase("0.75");
        register.recordPurchase("1.5");
        register.enterDollars(2);
        register.enterDimes(3);
        System.out.println("Change: " + register.giveChange());
        System.out.println("Expected: 0.05");

    }
}
