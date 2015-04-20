package com.epam.pashkov.labs1;

/**
 * Created by Yaroslav on 18.04.2015.
 */
public class ArrayInverter {
    public static void invert(int[] arr) {
        for (int k = (arr.length-1) / 2; k >= 0; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }
}
