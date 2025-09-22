package ru.aaa34.homework.module1.ex2;

import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) {
        // Сканнер для считывания введенных данных из консоли
        Scanner sc = new Scanner(System.in);

        // Выводим краткую инфу по нашей программе
        System.out.println("Консольный калькулятор");
        System.out.println("""
                Данный калькулятор поддерживает следующие операции:
                 * Сложение ( + )
                 * Вычитание ( - )
                 * Умножение ( * )
                 * Деление ( / )
                 * Целочисленное деление ( // )
                 * Возведение в степень ( ^ )
                 * Остаток от деления ( % )
                
                Для корректной работы калькулятора необходимо вводить выражение по следующему шаблону:
                 *Первое число* (Оператор действия) *Второе число*
                 Пример: 12 // 5 
                 
                Для выхода из программы введите команду \"exit\".                
                """);

        // Бесконечный цикл
        while (true){
            System.out.println("Введите выражение:");
            String expression = sc.nextLine();

            if (expression.equals("exit"))
                break;

            String[] array = expression.split(" ");

            if (checkExpression(array)) {
                // Тк мы проверили выражение и нам вернули true, то мы можем спокойно вытащить из выражения числа
                double num1 = Double.parseDouble(array[0]);
                double num2 = Double.parseDouble(array[2]);

                // Смотрим на оператор действия, выполняем метод и выводим результат
                switch (array[1]) {
                    case "+":
                        System.out.println("Результат: " + sum(num1, num2));
                        break;
                    case "-":
                        System.out.println("Результат: " + subtract(num1, num2));
                        break;
                    case "*":
                        System.out.println("Результат: " + multiply(num1, num2));
                        break;
                    case "/":
                        System.out.println("Результат: " + divide(num1, num2));
                        break;
                    case "//":
                        System.out.println("Результат: " + intDivide(num1, num2));
                        break;
                    case "^":
                        System.out.println("Результат: " + degree(num1, num2));
                        break;
                    case "%":
                        System.out.println("Результат: " + divisionRemainder(num1, num2));
                        break;
                    default:
                        System.out.println("Отсутствует оператор действия. Введите ещё раз:");
                        break;
                }
            }
        }
        System.out.println("Выход из программы...");
    }

    // Проверка на корректность ввода выражения. Чуть позже добавлю на проверку оператора действия
    public static boolean checkExpression(String[] arrayExpression) {
        if (arrayExpression.length < 3) {
            System.out.println("Ошибка! Некорректное выражение.");
            return false;
        }

        try {
            Double.parseDouble(arrayExpression[0]);
            Double.parseDouble(arrayExpression[2]);
        }
        catch (Exception e) {
            System.out.println("Ошибка! Не удалось форматировать выражение.");
            return false;
        }
        return true;
    }

    // Ниже методы для операторов

    private static double divisionRemainder(double num1, double num2) {
        return num1 % num2;
    }

    private static double degree(double num1, double num2) {
        double rez = 0;
        for (int i = 0; i < (int)num2; i++) {
            rez += num1;
        }
        return rez;
    }

    private static int intDivide(double num1, double num2) {
        return (int)num1 / (int)num2;
    }

    private static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Ошибка - деление на 0!");
            return 0;
        }
        return num1 / num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static double sum(double num1, double num2) {
        return num1 + num2;
    }
}
