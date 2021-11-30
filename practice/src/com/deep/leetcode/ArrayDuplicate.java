package com.deep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ArrayDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        ArrayDuplicate obj = new ArrayDuplicate();
        if (obj.containsDuplicate(arr)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
