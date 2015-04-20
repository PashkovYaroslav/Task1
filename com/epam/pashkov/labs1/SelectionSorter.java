package com.epam.pashkov.labs1;

/**
 * Created by Yaroslav on 18.04.2015.
 */
public class SelectionSorter {
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int minIndex = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[minIndex] > arr[index]) {
                    minIndex = index;
                }
            }
            int tmp = arr[barrier];
            arr[barrier] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }
}
