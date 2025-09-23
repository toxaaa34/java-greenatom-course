package ru.aaa34.homework.module2.ex1;

import ru.aaa34.homework.module2.ex1.operations.*;

public class Calculator {
    public double calculate(Operation operation) {
        return operation.calculate();
    }

    public Operation createOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return new Addition(num1, num2);
            case "-":
                return new Subtraction(num1, num2);
            case "*":
                return new Multiplication(num1, num2);
            case "/":
                return new Division(num1, num2);
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}
