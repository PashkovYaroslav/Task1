package com.epam.pashkov;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Yaroslav_Pashkov on 4/15/2015.
 */
public class Task1 {
    public static void main(String[] args) {
        subtask1(args);
        subtask2(args);
        subtask3(args);
        subtask4(args);
        subtask5(args);
        subtask6();
    }

    private static void subtask1(String[] args) {
        System.out.println("Привет, " + args[0].toString());
    }

    private static void subtask2(String[] args) {
        String newArgs = "";
        for (int i = args.length - 1; i >= 0; i--) {
            newArgs += args[i] + " ";
        }

        System.out.println(newArgs);
    }

    private static void subtask3(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            System.out.println(rnd.nextInt(10));
        }

        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            System.out.print(rnd.nextInt(10) + " ");
        }
        System.out.println();
    }

    private static void subtask4(String[] args) {
        String password = "qwerty";

        if (args[0].equals(password)) {
            System.out.println("Пароли совпадают");
        } else {
            System.out.println("Пароли не совпадают");
        }
    }


    private static void subtask5(String[] args) {
        int sum = 0;
        int mult = 1;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
            mult *= Integer.parseInt(args[i]);
        }
        System.out.println("Сумма равна " + sum + ", произведение равно " + mult);

    }

    public static void subtask6() {
        ArrayList<String> inputArray = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа:");
        while (sc.hasNextLine()) {
            String i = sc.nextLine();
            if (i.equals("Exit")) {
                break;
            }
            inputArray.add(i);
        }
        sc.close();

        System.out.println("Четные числа:");
        for (int i = 0; i < inputArray.size(); i++) {
            if (Integer.parseInt(inputArray.get(i)) % 2 == 0) {
                System.out.println(inputArray.get(i));
            }
        }

        System.out.println("Нечетные числа");
        for (int i = 0; i < inputArray.size(); i++) {
            if (Integer.parseInt(inputArray.get(i)) % 2 != 0) {
                System.out.println(inputArray.get(i));
            }
        }

        System.out.println("Наибольшее число:");
        int max = Integer.parseInt(inputArray.get(0));
        for (int i = 0; i < inputArray.size(); i++) {
            if (max < Integer.parseInt(inputArray.get(i))) {
                max = Integer.parseInt(inputArray.get(i));
            }
        }
        System.out.println(max);

        System.out.println("Наименьшее число:");
        int min = Integer.parseInt(inputArray.get(0));
        for (int i = 0; i < inputArray.size(); i++) {
            if (min > Integer.parseInt(inputArray.get(i))) {
                min = Integer.parseInt(inputArray.get(i));
            }
        }
        System.out.println(min);

        System.out.println("Числа, которые делятся на 3 или на 9:");
        for (int i = 0; i < inputArray.size(); i++) {
            if (Integer.parseInt(inputArray.get(i)) % 3 == 0 || Integer.parseInt(inputArray.get(i)) % 9 == 0) {
                System.out.println(inputArray.get(i));
            }
        }

        System.out.println("Числа, которые делятся на 5 или на 7:");
        for (int i = 0; i < inputArray.size(); i++) {
            if (Integer.parseInt(inputArray.get(i)) % 5 == 0 || Integer.parseInt(inputArray.get(i)) % 7 == 0) {
                System.out.println(inputArray.get(i));
            }
        }

        System.out.println("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр:");
        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i).length() == 3) {
                if (inputArray.get(i).charAt(0) != inputArray.get(i).charAt(1) && inputArray.get(i).charAt(1) != inputArray.get(i).charAt(2) && inputArray.get(i).charAt(0) != inputArray.get(i).charAt(2)) {
                    System.out.println(inputArray.get(i));
                }
            }
        }

        System.out.println("Счастливые числа:");
        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i).length() % 2 == 0) {
                int half = inputArray.get(i).length() / 2;
                int sumFirst = 0;
                int sumSecond = 0;

                for (int j = 0; j < half; j++) {
                    sumFirst += inputArray.get(i).charAt(j);
                }

                for (int j = half; j < inputArray.get(i).length(); j++) {
                    sumSecond += inputArray.get(i).charAt(j);
                }

                if (sumFirst == sumSecond) {
                    System.out.println(inputArray.get(i));
                }
            }
        }

        System.out.println("Элементы, которые равны полусумме соседних элементов:");
        if (inputArray.size() >= 3) {
            for (int i = 1; i < inputArray.size() - 1; i++) {
                int halfSum = (Integer.parseInt(inputArray.get(i - 1)) + Integer.parseInt(inputArray.get(i + 1))) / 2;

                if (Integer.parseInt(inputArray.get(i)) == halfSum) {
                    System.out.println(inputArray.get(i));
                }
            }
        }
    }
}
