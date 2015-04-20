package com.epam.pashkov.labs1;

import java.util.Arrays;

/**
 * Created by Yaroslav on 18.04.2015.
 */
public class InsertionSorter {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int newElement = arr[i];
            if(arr[i-1]>arr[i])
            {
                int newIndex = Arrays.binarySearch(arr, 0, i-1, arr[i]);
                //если такого элемента больше нет в массиве
                if(newIndex<0){
                    newIndex = Math.abs(newIndex) - 1;
                }
                else{
                    newIndex=newIndex+1;
                }

                System.arraycopy(arr,newIndex,arr,newIndex+1,i-newIndex);
                arr[newIndex] = newElement;
            }

            /*int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;*/
        }
    }
}
