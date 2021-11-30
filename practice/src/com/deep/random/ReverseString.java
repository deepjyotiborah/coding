package com.deep.random;

public class ReverseString {

    public static void reverse(String inputStr) {
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            System.out.print(inputStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        reverse("MyJavaProgram");
    }
}
