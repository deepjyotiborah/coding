package com.deep.random;

import java.util.*;


public class Test {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("aa");
        hashSet.add(null);
        System.out.println(hashSet);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(new String("a"), "aa");
        hashMap.put(new String("a"), "bb");
        System.out.println(hashMap);

        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new String("c"),"cc");
        identityHashMap.put(new String("c"),"dd");
        System.out.println(identityHashMap);

        final String a = "Test";
        System.out.println(a + " final");

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(20,0.8f,true);
        linkedHashMap.put("a","a");
        linkedHashMap.put("b", "b");
        linkedHashMap.put("c","c");

        System.out.println("linkedHashMap - " + linkedHashMap);

        linkedHashMap.get("a");
        linkedHashMap.get("a");
        System.out.println("linkedHashMap - " + linkedHashMap);

    }
}
