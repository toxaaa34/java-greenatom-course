package ru.aaa34.homework.module3;

public sealed abstract class TransportWithoutEngine extends Transport permits Skate, Bicycle{

    public TransportWithoutEngine(String name, int capacity) {
        super(name, capacity);
    }

    public abstract void pickUp();
}
