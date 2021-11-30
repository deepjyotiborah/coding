package com.deep.random;

public class FirstNonRepeatingCharacter {

    static int NO_OF_CHARS = 256;
    static char[] count = new char[NO_OF_CHARS];

    private static void getCharCountArray(String input){
        for (int i = 0; i < input.length(); i++){
            count[input.charAt(i)]++;
        }
    }

    private static int firstNonRepeatingChar(String input) {
        getCharCountArray(input);

        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if (count[input.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String input = "aabbcgfdso";
        int index = firstNonRepeatingChar(input);
        System.out.println("First non-repeating char - " + input.charAt(index));
    }
}
