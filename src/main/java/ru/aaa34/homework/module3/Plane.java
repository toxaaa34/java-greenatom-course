package ru.aaa34.homework.module3;

public final class Plane extends TransportWithEngine {
    private PlaneType planeType;

    public Plane(String name, int capacity, Engine engine, PlaneType planeType) {
        super(name, capacity, engine);
        this.planeType = planeType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Самолет " + name + ", вместимость " + capacity + ".\r\n" +
                "Двигатель:" + engine.getModel() + " с мощностью " + engine.getPower() + " кВт" +
                "\r\n" + "Тип самолёта: " + planeType.name());
    }

    @Override
    public void drive() {
        System.out.println("Виииииу, самолет летит вверх!");
    }

    @Override
    public void startEngine() {
        System.out.println("Запускается двигатель " + engine.getModel());
    }

    @Override
    public void offEngine() {
        System.out.println("Заглушается двигатель " + engine.getModel());
    }

    public void landOn() {
        System.out.println("Приземляюсь");
    }
}
