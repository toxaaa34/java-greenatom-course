package ru.aaa34.homework.module2.ex1.operations;

public class Division extends Operation{
    public Division(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double calculate() {
        if (num2 == 0) {
            throw new ArithmeticException("Ошибка - деление на 0!");
        }
        return num1 / num2;
    }

    @Override
    public String getOperator() {
        return "/";
    }
}
