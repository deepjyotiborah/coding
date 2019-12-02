package com.deep.datastructure.stack.problems;

import java.util.Stack;

public class InfixToPostfix {
    static int prec(char ch) {
        switch (ch) {
            case '+' :
            case  '-': return 1;
            case '*':
            case '/': return 2;
            case '^' : return 3;
        }

        return -1;
    }

    static void infixToPostFix(String input) {
        Stack<Character> characterStack = new Stack<>();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(Character.isLetterOrDigit(ch)) {
                result += ch;
            }else if(ch == '(') {
                characterStack.push(ch);
            }else if(ch == ')') {
                while (!characterStack.empty() && characterStack.peek() != '(') {
                    result += characterStack.pop();
                }
                if(!characterStack.empty() && characterStack.peek() != '(') {
                    System.out.println("Invalid Expression");
                    return;
                } else {
                    characterStack.pop();
                }
            }else {
                while (!characterStack.empty() && prec(ch) <= prec(characterStack.peek())) {
                    result += characterStack.pop();
                }
                characterStack.push(ch);
            }
        }
        while (!characterStack.empty()) {
            result += characterStack.pop();
        }

        System.out.println("Postfix expression is - " + result);
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        infixToPostFix(exp);
    }
}
