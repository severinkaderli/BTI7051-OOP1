/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

public class CarTester {
    public static void main(String[] args) {
        Car car = new Car(10);
        System.out.println("Expected 0: " + car.getGasLevel());
        car.fillUpTank(30);
        System.out.println("Expected 30: " + car.getGasLevel());
        car.drive(200);
        System.out.println("Expected 10: " + car.getGasLevel());
    }
}
