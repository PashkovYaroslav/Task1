package com.epam.pashkov.labs1;

import java.util.Arrays;

/**
 * Created by Yaroslav on 18.04.2015.
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Инвертированный массив:");
        int[] arN = {-4,0,0,2,-4,-1,0,3,-2,0,1,3,-2,0,1,4,1};
        ArrayInverter.invert(arN);
        System.out.println(Arrays.toString(arN));

        System.out.println("Слияние двух массивов:");
        int[] arN2 = {1,3,8,4,5,1};
        int[] arN1 = {4,5,3,4,2,3,1,2,0,1};
        System.out.println(Arrays.toString(Merger.merge(arN1,arN2)));

        System.out.println("Сортировка пузырьком:");
        arN1 = new int[]{4, 5, 3, 4, 2, 3, 1, 2, 0, 1};
        BubbleSorter.sort(arN1);
        System.out.println(Arrays.toString(arN1));

        System.out.println("Сортировка выбором:");
        arN1 = new int[]{4, 5, 3, 4, 2, 3, 1, 2, 0, 1};
        SelectionSorter.sort(arN1);
        System.out.println(Arrays.toString(arN1));

        System.out.println("Сортировка вставкой:");
        arN1 = new int[]{4, 5, 3, 4, 2, 3, 1, 2, 0, 1};
        InsertionSorter.sort(arN1);
        System.out.println(Arrays.toString(arN1));

        int[][] a = {{1,2},{7,8},{3,4}};
        int[][] b = {{3,4,5,6},{9,0,1,2}};

        System.out.println("Умножение матриц:");
        try {
            print(MatrixMul.mul(a, b));
        }
        catch(IllegalArgumentException e){
            System.out.println("Что-то пошло не так(");
        }
    }

    private static void print(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
