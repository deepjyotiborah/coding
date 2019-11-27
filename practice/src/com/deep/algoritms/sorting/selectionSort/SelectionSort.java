package com.deep.algoritms.sorting.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    private void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min_Idx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_Idx]) {
                    min_Idx = j;
                }
            }
            int temp = arr[min_Idx];
            arr[min_Idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 7,5};
        System.out.println("Before Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println("After sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
