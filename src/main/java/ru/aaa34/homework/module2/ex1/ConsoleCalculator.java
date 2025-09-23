package ru.aaa34.homework.module2.ex1;

import ru.aaa34.homework.module2.ex1.operations.Operation;

import java.util.Scanner;

public class ConsoleCalculator {
    private Calculator calculator;

    public ConsoleCalculator() {
        this.calculator = new Calculator();
    }

    public void start() {
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

        while (true) {
            try {
                System.out.print("Введите выражение: ");
                String expression = sc.nextLine();

                if (expression.equals("exit"))
                    break;

                if (!ExpressionValidator.isValidExpression(expression)) {
                    System.out.println("Ошибка: Неверный формат выражения!");
                    System.out.println("Правильный формат: число оператор число");
                    continue;
                }

                String[] array = expression.split(" ");
                double operand1 = Double.parseDouble(array[0]);
                String operator = array[1];
                double operand2 = Double.parseDouble(array[2]);

                // Создаем операцию через калькулятор
                Operation operation = calculator.createOperation(operand1, operand2, operator);

                // Выполняем вычисление
                double result = calculator.calculate(operation);

                System.out.printf("Результат: " + result);
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Неверный формат числа!");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }
        }
        System.out.println("Выход из программы...");
    }
}
