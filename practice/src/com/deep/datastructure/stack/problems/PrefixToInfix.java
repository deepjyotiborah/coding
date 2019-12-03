package com.deep.datastructure.stack.problems;

import java.util.Stack;

public class PrefixToInfix {
    private static boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/': return true;
        }
        return false;
    }

    private static void prefixToInfix(String expr) {
        Stack<String> characterStack = new Stack<>();
        for (int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);
            if(isOperator(ch)) {
                String first = characterStack.pop();
                String second = characterStack.pop();
                String tmp = "(" + first + ch + second + ")";
                characterStack.push(tmp);
            } else {
                characterStack.push( ch + "");
            }
        }

        System.out.println("Infix expression is - " + characterStack.pop());
    }

    public static void main(String[] args) {
       String pre_exp = "*-A/BC-/AKL";
       prefixToInfix(pre_exp);
    }
}
