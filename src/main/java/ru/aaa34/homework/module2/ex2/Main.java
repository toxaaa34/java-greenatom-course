package ru.aaa34.homework.module2.ex2;

public class Main {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);

        System.out.println("Вектор 1: " + v1);
        System.out.println("Вектор 2: " + v2);
        System.out.println("Длина v1: " + v1.length());
        System.out.println("Длина v2: " + v2.length());
        System.out.println("Скалярное произведение: " + v1.scalarProduct(v2));
        System.out.println("Векторное произведение: " + v1.crossProduct(v2));
        System.out.println("Косинус угла: " + v1.cosAngle(v2));
        System.out.println("Сумма: " + v1.sum(v2));
        System.out.println("Разность: " + v1.subtract(v2));

        Vector3D[] randomVectors = Vector3D.generateRandomVectors(5);
        System.out.println("\nСлучайные векторы:");
        for (Vector3D v : randomVectors) {
            System.out.println(v);
        }
    }
}
