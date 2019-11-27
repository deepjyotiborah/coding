package com.deep.algoritms.searching.LinearSearch;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int idx = search(arr, 4);
        if(idx == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Key found at index " + idx);
        }
    }

    private static int search(int[] arr , int key) {
        int idx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
