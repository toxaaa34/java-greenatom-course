package ru.aaa34.homework.module3;

public final class Car extends TransportWithEngine{
    private final String brand;
    private final String model;

    public Car(String brand, String model, int capacity, Engine engine) {
        super(brand + " " + model, capacity, engine);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void displayInfo() {
        System.out.println("Автомобиль " + name + ", вместимость " + capacity + " человек.\r\n" +
                "Двигатель:" + engine.getModel() + " с мощностью " + engine.getPower() + " кВт");
    }

    @Override
    public void drive() {
        System.out.println("Врум-врум, машина едет вперед!");
    }

    @Override
    public void startEngine() {
        System.out.println("Запускается двигатель " + engine.getModel());
    }

    @Override
    public void offEngine() {
        System.out.println("Заглушается двигатель " + engine.getModel());
    }

    public void drift() {
        System.out.println("Уходим в управляемый занос (੭˃ᴗ˂)੭");
    }
}
