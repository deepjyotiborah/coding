package com.deep.algoritms.searching.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int idx = binarySearch.search(arr, 0, n - 1, 10);

        if(idx == -1) {
            System.out.println("Key not found.");
        }else {
            System.out.println("Key found at index " + idx);
        }
    }

    private int search(int[] arr, int l, int h, int key) {
        if(h >= l) {
            int mid = (l + h) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if(arr[mid] > key) {
                return search(arr, l, mid - 1, key);
            }

            if(arr[mid] < key) {
                return search(arr, mid + 1, h, key);
            }
        }
        return -1;
    }
}
