package com.deep.random;

public class TrailingZerosInAFactorial {
//    Trailing 0s in n! = Count of 5s in prime factors of n!
//            = floor(n/5) + floor(n/25) + floor(n/125) + ....

    public static void main(String[] args) {
        System.out.println("Trailing zeros in factorial - " + findTrailingZeros(100));
    }

    static int findTrailingZeros(int n) {
        if (n < 0) {
            return -1;
        }

        int count = 0;
        for (int i = 5; n/i >= 1; i = i * 5) {
            count += n/i;
        }

        return count;
    }
}
