package ru.aaa34.homework.module2.ex1;

public class ExpressionValidator {
    public static boolean isValidExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return false;
        }

        String[] array = expression.split(" ");
        if (array.length != 3) {
            return false;
        }

        try {
            Double.parseDouble(array[0]);
            Double.parseDouble(array[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        String operator = array[1];
        return operator.equals("+") || operator.equals("-") ||
                operator.equals("*") || operator.equals("/");
    }
}
