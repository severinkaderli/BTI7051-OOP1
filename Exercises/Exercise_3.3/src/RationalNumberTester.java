public class RationalNumberTester {
    public static void main(String[] args) {
        RationalNumber number = new RationalNumber(5, 10);
        System.out.println("Expected string: 1/2, Got: " + number.toString());
        System.out.println("Expected double: 0.5, Got: " + number.toDouble());

        number = number.multiply(new RationalNumber(3, 5));
        System.out.println("Expected string: 3/10, Got: " + number.toString());
        System.out.println("Expected double: 0.3, Got: " + number.toDouble());

        number = new RationalNumber(4, 20);
        number = number.add(new RationalNumber(2, 20));
        System.out.println("Expected string: 3/10, Got: " + number.toString());
        System.out.println("Expected double: 0.3, Got: " + number.toDouble());

        number = new RationalNumber(325);
        System.out.println("Expected string: 325/1, Got: " + number.toString());
        System.out.println("Expected double: 325.0, Got: " + number.toDouble());

        System.out.println(number);
    }
}
