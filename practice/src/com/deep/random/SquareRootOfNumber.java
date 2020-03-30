package com.deep.random;

public class SquareRootOfNumber {

    private int squareRoot(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int i = 1, result = 1;

        while (result <= n) {
            i++;
            result = i * i;
        }

        return i - 1;
    }

    public static void main(String[] args) {
        SquareRootOfNumber squareRootOfNumber = new SquareRootOfNumber();
        System.out.println("Square root of 81 is - " + squareRootOfNumber.squareRoot(81));
    }
}
