package com.deep.algoritms.searching.jumpSearch;

public class JumpSearch {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 55;

        JumpSearch jumpSearch = new JumpSearch();
        int idx = jumpSearch.search(arr, x);

        System.out.println("\nNumber " + x +
                " is at index " + idx);
    }

    private int search(int[] arr, int key) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if(prev >= n)
                return -1;
        }

        while (arr[prev] < key) {
            prev++;
            if(prev == Math.min(step,n))
                return -1;
        }

        if(arr[prev] == key)
            return prev;

        return -1;
    }
}
