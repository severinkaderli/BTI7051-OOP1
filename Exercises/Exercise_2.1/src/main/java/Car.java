/**
 * Represents a car.
 *
 * @author Severin Kaderli
 */
public class Car {
    /**
     * The current gas level of the car in liters.
     */
    private int gasLevel;

    /**
     * The gas consumption of the car in liters/100km.
     */
    private int gasConsumption;

    /**
     * Creates a new instance of car with the given consumption.
     *
     * @param gasConsumption The gas consumption in liters/100km
     */
    public Car(int gasConsumption) {
        this.gasLevel = 0;
        this.gasConsumption = gasConsumption;
    }

    /**
     * Fill up the tank
     *
     * @param amount The amount in liters
     */
    public void fillUpTank(int amount) {
        gasLevel += amount;
    }

    /**
     * "Drive" a certain distrance with the car and use the
     * correct amount of gas.
     *
     * @param distance The driving distance in km
     */
    public void drive(int distance) {
        gasLevel -= distance * gasConsumption * 0.01;
    }

    /**
     * Returns the current gas level.
     *
     * @return The current gas level in liters.
     */
    public int getGasLevel() {
        return gasLevel;
    }
}
