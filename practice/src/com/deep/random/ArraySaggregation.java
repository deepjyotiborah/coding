package com.deep.random;

import java.util.Arrays;

public class ArraySaggregation {
    public static void sort012(int[] arr) {
        int size = arr.length;
        int low =0, mid = 0, temp = 0;
        int high = size - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 : temp = arr[mid];
                         arr[mid] = arr[low];
                         arr[low] = temp;
                         mid++;
                         low++;
                         break;
                case 1: mid++;
                        break;
                case 2 : temp = arr[mid];
                         arr[mid] = arr[high];
                         arr[high] = temp;
                         high--;
                         break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,1,1,0,0,2,0,2,2,0,1,0};
        System.out.println("Before sort -> ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        sort012(arr);
        System.out.println("After sort -> ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
