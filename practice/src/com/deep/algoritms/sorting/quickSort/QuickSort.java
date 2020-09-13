package com.deep.algoritms.sorting.quickSort;

import java.util.Arrays;

public class QuickSort {
    private int partition(int arr[], int l, int h) {

        int pivot = arr[h];
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return i+1;
    }

    private void sort(int[] arr, int l, int  h) {
        if (l < h) {
            int p = partition(arr, l, h);
            sort(arr, l, p-1);
            sort(arr, p+1, h);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {12, 11, 13, 6, 5, 7};
        System.out.println("Before Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println("After Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
