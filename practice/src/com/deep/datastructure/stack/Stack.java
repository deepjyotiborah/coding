package com.deep.datastructure.stack;

public class Stack {

    private int MAX = 5;
    private int top;
    private int[] stack = new int[MAX];

    public Stack() {
        this.top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int item) {
        if(top == MAX - 1) {
            System.out.println("Stack overflow.");
            return;
        }
        stack[++top] = item;
        System.out.println(item + " pushed into the stack.");
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            System.exit(0);
        }

        int itm = stack[top--];
        System.out.println(itm + " is removed from stack.");
        return itm;
    }

    public void display() {
        for(int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
    }
}
