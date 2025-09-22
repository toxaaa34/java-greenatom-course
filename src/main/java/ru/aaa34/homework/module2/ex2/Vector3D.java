package ru.aaa34.homework.module2.ex2;

import java.util.Random;

public final class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Длина вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Скалярное произведение
    public double scalarProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Векторное произведение
    public Vector3D crossProduct(Vector3D other) {
        double newX = this.y * other.z - this.z * other.y;
        double newY = this.z * other.x - this.x * other.z;
        double newZ = this.x * other.y - this.y * other.x;
        return new Vector3D(newX, newY, newZ);
    }

    // Косинус угла между векторами
    public double cosAngle(Vector3D other) {
        double scalarProduct = this.scalarProduct(other);
        double lengthProduct = this.length() * other.length();

        if (lengthProduct == 0) {
            throw new ArithmeticException("Невозможно вычислить угол с нулевым вектором");
        }

        return scalarProduct / lengthProduct;
    }

    // Сумма векторов
    public Vector3D sum(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Разность векторов
    public Vector3D subtract(Vector3D other) {
        return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Создание массива случайных векторов
    public static Vector3D[] generateRandomVectors(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Длина массива не должна быть <= 0");
        }

        Random random = new Random();
        Vector3D[] vectors = new Vector3D[N];

        for (int i = 0; i < N; i++) {
            double x = random.nextDouble() * 20 - 10;
            double y = random.nextDouble() * 20 - 10;
            double z = random.nextDouble() * 20 - 10;
            vectors[i] = new Vector3D(x, y, z);
        }

        return vectors;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("Vector3D(%.2f, %.2f, %.2f)", x, y, z);
    }
}
