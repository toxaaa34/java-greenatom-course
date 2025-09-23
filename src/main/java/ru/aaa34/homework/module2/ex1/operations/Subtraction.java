package ru.aaa34.homework.module2.ex1.operations;

public class Subtraction extends Operation{
    public Subtraction(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double calculate() {
        return num1 - num2;
    }

    @Override
    public String getOperator() {
        return "-";
    }
}
