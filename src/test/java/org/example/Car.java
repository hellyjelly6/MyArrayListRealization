package org.example;

/**
 *
 */
public class Car implements Comparable<Car>{

    private int manufactureYear;
    private String model;
    private int maxSpeed;

    public Car(int manufactureYear, String model, int maxSpeed) {
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    /**
     * @return
     */
    public int getManufactureYear() {
        return manufactureYear;
    }

    /**
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * @return
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }


    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Car o) {
        return this.manufactureYear-o.manufactureYear;
    }
}
