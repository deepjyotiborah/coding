package com.deep.algoritms.sorting.mergeSort;

import java.util.Arrays;

public class MergeSort {


    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for(int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;

        while (i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[j] = right[j];
            j++;
            k++;
        }
    }

    private void sort(int[] arr, int l, int r) {
        if(l < r) {
             int m = (l + r)/2;

             sort(arr, l, m);
             sort(arr, m+1, r);
             merge(arr,l,m,r);

        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 6, 5, 7};
        System.out.println("Before Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);
        System.out.println("After sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
