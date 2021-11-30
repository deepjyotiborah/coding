package com.deep.random;

public class ReverseDigit {
    private static void reverse(int number) {
        int reverseNumber = 0;
        while (number > 0) {
            reverseNumber = reverseNumber  * 10 + number % 10;
            number = number/10;
        }
        System.out.println("Reverse Number - " + reverseNumber);
    }


    public static void main(String[] args) {
        reverse(2345);
    }
}
