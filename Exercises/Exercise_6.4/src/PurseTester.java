public class PurseTester {
    public static void main(String[] args) {
        Purse a = new Purse();
        a.addCoin(Coin.QUARTER);
        a.addCoin(Coin.QUARTER);
        a.addCoin(Coin.DIME);
        a.addCoin(Coin.PENNY);
        a.addCoin(Coin.QUARTER);
        System.out.println(a);
        System.out.println(a.getValue());

        Purse b = new Purse();
        b.addCoin(Coin.QUARTER);
        b.addCoin(Coin.DIME);
        b.addCoin(Coin.PENNY);
        b.addCoin(Coin.QUARTER);
        b.addCoin(Coin.QUARTER);
        System.out.println(b);
        System.out.println(b.getValue());

        System.out.println(a.sameValue(b));
        System.out.println(a.sameCoins(b));

        Purse c = new Purse(Coin.QUARTER, Coin.DIME, Coin.DIME, Coin.DIME, Coin.PENNY, Coin.QUARTER, Coin.NICKEL);
        System.out.println(c);
        System.out.println(c.getValue());

        System.out.println(a.sameValue(c));
        System.out.println(a.sameCoins(c));

        c.transferTo(a);
        System.out.println(a);
        System.out.println(c);

        a.transferFrom(b);
        System.out.println(a);
        System.out.println(b);

    }
}