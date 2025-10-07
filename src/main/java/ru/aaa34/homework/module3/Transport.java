package ru.aaa34.homework.module3;

public sealed abstract class Transport permits TransportWithEngine, TransportWithoutEngine {
    protected final String name;
    protected final int capacity;

    public Transport(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public abstract void displayInfo();
    public abstract void drive();
}
