package com.deep.leetcode;

/*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int k = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j])
                arr[k++] = nums1[i++];
            else
                arr[k++] = nums2[j++];
        }

        while (i < m) {
            arr[k++] = nums1[i++];
        }

        while (j < n) {
            arr[k++] = nums2[j++];
        }
        for (int index = 0; index < arr.length; index++)
            nums1[index] = arr[index];
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] l1 = new int[]{1,2,3,0,0,0};
        int[] l2 = new int[]{2,5,6};
        mergeSortedArrays.merge(l1, 3, l2, 3);
        System.out.println(l1);
    }
}
