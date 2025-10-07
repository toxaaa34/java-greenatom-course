package ru.aaa34.homework.module3;

public class Engine {
    private final String model;
    private final int power;
    private final FuelType fuelType;

    public Engine(String model, int power, FuelType fuelType) {
        this.model = model;
        this.power = power;
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Engine:" +
                " model='" + model + '\'' +
                ", power=" + power +
                ", fuelType=" + fuelType;
    }
}
