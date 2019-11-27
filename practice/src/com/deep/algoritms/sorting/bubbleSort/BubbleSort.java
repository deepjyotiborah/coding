package com.deep.algoritms.sorting.bubbleSort;

import com.deep.algoritms.sorting.selectionSort.SelectionSort;

import java.util.Arrays;

public class BubbleSort {
    private void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 7,5};
        System.out.println("Before Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println("After sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

}
