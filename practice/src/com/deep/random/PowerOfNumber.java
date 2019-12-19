package com.deep.random;

public class PowerOfNumber {
    private int power(int n, int p) {
        if (p == 0)
            return 1;
        return n * power(n, p - 1);
    }

    public static void main(String[] args) {
        PowerOfNumber powerOfNumber = new PowerOfNumber();
        System.out.println(" 3 to the power 4 is " + powerOfNumber.power(3,4));
    }
}
