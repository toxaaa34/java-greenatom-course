package ru.aaa34.homework.module3;

public final class Bicycle extends TransportWithoutEngine {

    public Bicycle(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void displayInfo() {
        System.out.println("Велосипед " + name + ", для " + capacity + " человек");
    }

    @Override
    public void drive() {
        System.out.println("Дзынь-дзынь, велосипед едет вперед!");
    }

    @Override
    public void pickUp() {
        System.out.println("Вы слезли с велосипеда");
    }
}
