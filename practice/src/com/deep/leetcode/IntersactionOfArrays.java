package com.deep.leetcode;

/*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */

import java.util.*;

public class IntersactionOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        if (nums1.length > nums2.length) {
            updateMap(nums1, numberMap);
            return getIntersection(nums2, numberMap);
        } else {
            updateMap(nums2, numberMap);
            return getIntersection(nums1, numberMap);
        }
    }

    private int[] getIntersection(int[] arr, Map<Integer, Integer> numberMap) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Integer numCount = numberMap.get(arr[i]);
            if (numCount != null && numCount > 0) {
                numList.add(arr[i]);
                numberMap.put(arr[i], numberMap.get(arr[i]) - 1);
            }
        }
        return numList.stream().mapToInt(a -> a).toArray();
    }

    private void updateMap(int[] arr, Map<Integer, Integer> numberMap) {
        for (int i = 0; i < arr.length; i++) {
            if (numberMap.get(arr[i]) == null) {
                numberMap.put(arr[i], 1);
            } else {
                numberMap.put(arr[i], numberMap.get(arr[i]) + 1);
            }
        }
    }

    public static void main(String[] args) {
        IntersactionOfArrays obj = new IntersactionOfArrays();
        int[] l1 = new int[]{4,9,5};
        int[] l2 = new int[]{9,4,9,8,4};
        Arrays.stream(obj.intersect(l1, l2)).forEach(a -> System.out.print(a + " "));
    }
}
