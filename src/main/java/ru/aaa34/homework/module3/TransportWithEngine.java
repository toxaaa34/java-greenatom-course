package ru.aaa34.homework.module3;

public sealed abstract class TransportWithEngine extends Transport permits Car, Plane{
    protected Engine engine;

    public TransportWithEngine(String name, int capacity, Engine engine) {
        super(name, capacity);
        this.engine = engine;
    }

    public abstract void startEngine();
    public abstract void offEngine();
}
