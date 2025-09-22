package ru.aaa34.homework.ex1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Ошибка! Размер массива должен быть больше 0");
            return;
        }

        System.out.println("Введите минимальное значение для генератора случайных чисел:");
        int minValue = sc.nextInt();
        System.out.println("Введите максимальное значение для генератора случайных чисел:");
        int maxValue = sc.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = minValue + (int) (Math.random() * (maxValue - minValue + 1));
        }


        System.out.println("Целочисленный массив:\n" + Arrays.toString(array));

        System.out.println("\nМаксимальное значение в массиве: " + maxArrayValue(array));
        System.out.println("Минимальное значение в массиве: " + minArrayValue(array));
        System.out.println("Среднее значение в массиве: " + avarageArrayValue(array));

        bubbleSort(array);
        System.out.println("Отсортированный массив (ASC):\n" + Arrays.toString(array));
        bubbleSort(array, true);
        System.out.println("Отсортированный массив (DESC):\n" + Arrays.toString(array));

        double[] arrayDouble = new double[size];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = minValue + (Math.random() * (maxValue - minValue + 1));
        }


        System.out.println("Массив с дробными значениями:\n" + Arrays.toString(arrayDouble));

        System.out.println("\nМаксимальное значение в массиве: " + maxArrayValue(arrayDouble));
        System.out.println("Минимальное значение в массиве: " + minArrayValue(arrayDouble));
        System.out.println("Среднее значение в массиве: " + avarageArrayValue(arrayDouble));

        bubbleSort(arrayDouble);
        System.out.println("Отсортированный массив (ASC):\n" + Arrays.toString(arrayDouble));
        bubbleSort(arrayDouble, true);
        System.out.println("Отсортированный массив (DESC):\n" + Arrays.toString(arrayDouble));
    }

    public static int maxArrayValue(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    public static double maxArrayValue(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    public static int minArrayValue(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    public static double minArrayValue(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    public static double avarageArrayValue(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return (double) sum / array.length;
    }

    public static double avarageArrayValue(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum / array.length;
    }

    public static void bubbleSort(int[] array, boolean desc){
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if (desc) {
                    if (array[j + 1] > array[j]) {
                        int swap = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = swap;
                    }
                }
                else {
                    if (array[j + 1] < array[j]) {
                        int swap = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = swap;
                    }
                }
            }
        }
    }

    public static void bubbleSort(double[] array, boolean desc){
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if (desc) {
                    if (array[j + 1] > array[j]) {
                        double swap = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = swap;
                    }
                }
                else {
                    if (array[j + 1] < array[j]) {
                        double swap = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = swap;
                    }
                }
            }
        }
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j + 1] < array[j]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }

    public static void bubbleSort(double[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j + 1] < array[j]) {
                    double swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }
}
