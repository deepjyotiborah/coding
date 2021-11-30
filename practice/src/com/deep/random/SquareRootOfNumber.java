package com.deep.random;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Resource
public class SquareRootOfNumber {

    @Resource(name = "test")
    protected int ignoreNum;

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


        List<String> l = new ArrayList<>();
        l.add("a");
        List<String> a1 = l.stream().filter(a -> !a.equals("a")).map(a -> a).collect(Collectors.toList());
        System.out.println("---> " +a1);
    }


}
