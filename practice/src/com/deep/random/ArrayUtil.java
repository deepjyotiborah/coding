package com.deep.random;

public class ArrayUtil {

    public static void main(String[] args) {
        String inputStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int strIndex  = 0;
        char arr[][] = new char[5][9];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 2*i+1) {
                    break;
                }
                arr[i][j] = inputStr.charAt(strIndex++);
            }
        for (int  i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0)
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
