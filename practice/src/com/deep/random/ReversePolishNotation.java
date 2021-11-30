package com.deep.random;

import java.util.Stack;
import java.util.regex.Pattern;

public class ReversePolishNotation {

    public static double evaluate(String expr) {

        if (expr == null || expr == "") {
            return 0;
        }

        validate(expr);
        Stack<String> stack = new Stack<>();
        String[] expressionsChars = expr.split("\\s+");

        double x = 0, y = 0;
        for (String expressionChar : expressionsChars) {

            switch (expressionChar) {
                case "+" :
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(x + y));
                    break;

                case "-" :
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(y - x));
                    break;

                case "*" :
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(x * y));
                    break;

                case "/" :
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(y / x));
                    break;

                default:
                    stack.push(expressionChar);
                    break;

            }
        }
        return Double.parseDouble(stack.pop());
    }

    private static void validate(String expr) {
        boolean matches = Pattern.matches(".*[a-zA-Z]+.*", expr);
        if (matches) {
            throw  new IllegalArgumentException("Expression can not have alpha characters");
        }
    }

    public static void main(String[] args) {
        System.out.println(evaluate("5 A1 2 + 4 * + 3 -"));
    }
}
