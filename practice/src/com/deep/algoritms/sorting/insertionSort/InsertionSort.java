package com.deep.algoritms.sorting.insertionSort;

import com.deep.algoritms.sorting.selectionSort.SelectionSort;

import java.util.Arrays;

public class InsertionSort {

    private void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 7,5};
        System.out.println("Before Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        System.out.println("After sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
