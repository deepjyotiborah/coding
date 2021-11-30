package com.deep.random;

public class SubArrayWithMaxSum {

    public static void main(String[] args) {
        int [] numbers = {7,-8,9,1};
        System.out.println("Sub array with maximum sum - " + maxSum(numbers));
    }

    static int maxSum(int[] arr) {
        int max_so_far = arr[0], cur_max = arr[0];
        for (int i =1; i < arr.length; i++) {
           cur_max = Math.max(arr[i], cur_max + arr[i]);
           max_so_far = Math.max(max_so_far, cur_max);
        }
        return max_so_far;
    }
}
