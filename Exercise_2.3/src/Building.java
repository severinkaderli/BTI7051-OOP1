public class Building {
    /**
     * The name of the building.
     */
    private String name;

    /**
     * The height of the building in meters.
     */
    private int height;

    /**
     * Creates a new building object.
     *
     * @param name The name of the building
     * @param height The height of the building in meters
     */
    public Building(String name, int height){
        this.name = name;
        this.height = height;
    }

    /**
     * Returns the name of the building.
     *
     * @return The name of the building
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the height of the building.
     *
     * @return The height of the building
     */
    public int getHeight() {
        return height;
    }


}
