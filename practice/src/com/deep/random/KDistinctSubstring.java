package com.deep.random;

import java.util.HashMap;
import java.util.Map;

public class KDistinctSubstring {
    public static int countDistinctSubstring(String str, int K) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < K; i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }

        if (map.size() == K) {
            result++;
        }

        for (int  i = K; i < str.length(); i++) {
            if (map.get(str.charAt(i)) ==  null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }

            //Decrease the frequency of first character of previous substring
            map.put(str.charAt(i  - K), map.get(str.charAt(i - K)) - 1);

            //If the character is not present in current substring
            if (map.get(str.charAt(i - K)) == 0) {
                map.remove(str.charAt(i - K));
            }

            if (map.size() == K) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(KDistinctSubstring.countDistinctSubstring("abacca", 3));
    }
}
