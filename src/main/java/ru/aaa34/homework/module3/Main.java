package ru.aaa34.homework.module3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Transport> transports = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readIntInput();
            switch (choice) {
                case 1 -> createTransport();
                case 2 -> listTransports();
                case 3 -> interactWithTransport();
                case 4 -> { return; }
                default -> System.out.println("Такого действия нет. Попробуйте ещё раз.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Система создания транспорта ===");
        System.out.println("\n Выберите действие из списка: ");
        System.out.println("1. Создать новый транспорт");
        System.out.println("2. Список созданных транспортных средств");
        System.out.println("3. Взаимодействовать с транспортом");
        System.out.println("4. Выход");
        System.out.print("Введите номер действия: ");
    }

    private static int readIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Некорректный ввод. Введите номер действия: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void createTransport() {
        System.out.println("\nВыберите транспорт:");
        System.out.println("1. Автомобиль");
        System.out.println("2. Самолёт");
        System.out.println("3. Скейт");
        System.out.println("4. Велосипед");
        System.out.print("Введите номер транспортного средства: ");

        int type = readIntInput();
        scanner.nextLine();

        switch (type) {
            case 1 -> createCar();
            case 2 -> createPlane();
            case 3 -> createSkate();
            case 4 -> createBicycle();
            default -> System.out.println("Некорректное значение.");
        }
    }

    private static void createCar() {
        System.out.print("Введите бренд автомобиля: ");
        String brand = scanner.nextLine();
        System.out.print("Введите модель автомобиля: ");
        String modelCar = scanner.nextLine();
        System.out.print("Введите вместимость (количество человек) автомобиля: ");
        int capacity = scanner.nextInt();
        System.out.print("Введите модель двигателя: ");
        String modelEngine = scanner.nextLine();
        System.out.print("Введите мощность двигателя (Вт): ");
        int power = scanner.nextInt();

        FuelType fuelType = selectFuelType();
        transports.add(new Car(brand, modelCar, capacity, new Engine(modelEngine, power, fuelType)));
    }

    private static void createPlane() {
        System.out.print("Введите название самолета: ");
        String name = scanner.nextLine();
        System.out.print("Введите вместимость (количество человек) самолета: ");
        int capacity = scanner.nextInt();
        System.out.print("Введите модель двигателя: ");
        String modelEngine = scanner.nextLine();
        System.out.print("Введите мощность двигателя (кВт): ");
        int power = scanner.nextInt();

        FuelType fuelType = selectFuelType();
        PlaneType planeType = selectPlaneType();
        transports.add(new Plane(name, capacity, new Engine(modelEngine, power, fuelType), planeType));
    }

    private static void createSkate() {
        System.out.print("Введите название скейта: ");
        String name = scanner.nextLine();
        System.out.print("Он трюковой? (да/нет) ");
        String forStuntString = scanner.nextLine();
        boolean forStunt = forStuntString.toLowerCase().equals("да");
        transports.add(new Skate(name, forStunt));
    }

    private static void createBicycle() {
        System.out.print("Введите название велосипеда: ");
        String name = scanner.nextLine();
        System.out.print("Введите вместимость (количество человек) велосипеда: ");
        int capacity = scanner.nextInt();
        transports.add(new Bicycle(name, capacity));
    }

    private static FuelType selectFuelType() {
        System.out.println("Выберите топливо для двигателя:");
        for (int i = 0; i < FuelType.values().length; i++) {
            System.out.printf(i + 1 + ". " + FuelType.values()[i] + " ");
        }
        System.out.print("\r\nВведите номер топлива из списка: ");
        int index = readIntInput() - 1;
        return (index >= 0 && index < FuelType.values().length)
                ? FuelType.values()[index]
                : FuelType.PETROL;
    }

    private static PlaneType selectPlaneType() {
        System.out.println("Выберите тип самолета:");
        for (int i = 0; i < PlaneType.values().length; i++) {
            System.out.printf(i + 1 + ". " + PlaneType.values()[i]);
        }
        System.out.print("Введите номер типа самолета из списка: ");
        int index = readIntInput() - 1;
        return (index >= 0 && index < PlaneType.values().length)
                ? PlaneType.values()[index]
                : PlaneType.PASSENGER;
    }

    private static void listTransports() {
        System.out.println("\n=== Список транспортных средств ===");
        if (transports.isEmpty()) System.out.println("Транспорт отсутствует. Создайте транспорт.");

        for (int i = 0; i < transports.size(); i++) {
            System.out.printf("%d. ", i + 1);
            transports.get(i).displayInfo();
        }
    }

    private static void interactWithTransport() {
        if (transports.isEmpty()) {
            System.out.println("Отсутствуют созданные транспортные средства.");
            return;
        }

        listTransports();
        System.out.print("Выберите транспорт: ");
        int index = readIntInput() - 1;

        if (index < 0 || index >= transports.size()) {
            System.out.println("Некорректное значение.");
            return;
        }

        Transport transport = transports.get(index);
        transport.displayInfo();

        // Вызов специфичных методов
        if (transport instanceof Car car) {
            car.startEngine();
            car.drive();
            car.drift();
            car.offEngine();
        }

        else if (transport instanceof Plane plane) {
            plane.startEngine();
            plane.drive();
            plane.landOn();
            plane.offEngine();
        }

        else if (transport instanceof Skate skate) {
            skate.drive();
            skate.makeStunt();
            skate.pickUp();
        }

        else if (transport instanceof Bicycle bicycle) {
            bicycle.drive();
            bicycle.pickUp();;
        }
    }
}
