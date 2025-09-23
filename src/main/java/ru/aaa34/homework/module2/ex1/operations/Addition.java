package ru.aaa34.homework.module2.ex1.operations;

public class Addition extends Operation{
    public Addition(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double calculate() {
        return num1 + num2;
    }

    @Override
    public String getOperator() {
        return "+";
    }
}
