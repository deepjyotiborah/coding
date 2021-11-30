package com.deep.datastructure.stack;

public class TwoStacksInOneArray {
    private final int MAX = 10;
    private int topLeft, topRight;
    private int[] stackArray = new int[MAX];

    public TwoStacksInOneArray() {
        this.topLeft = -1;
        this.topRight = MAX;
    }

    private void pushLeft(int item) {
        if (topLeft < topRight) {
            stackArray[++topLeft] = item;
            System.out.println(item + " inserted in first stack.");
        } else {
            System.out.println("Stack1 overflow.");
            return;
        }
    }

    private void pushRight(int item) {
        if(topLeft < topRight) {
            stackArray[--topRight] = item;
            System.out.println(item + " inserted in second stack.");
        } else {
            System.out.println("Stack overflow");
            return;
        }
    }

    private void popLeft() {
        if(topLeft == -1) {
            System.out.println("First stack is empty");
            return;
        }
        int itm = stackArray[topLeft];
        topLeft--;
        System.out.println(itm + " removed from first stack.");
    }

    private void popRight() {
        if(topRight == MAX - 1) {
            System.out.println("Second stack is empty");

        }
        int itm = stackArray[topRight];
        topRight++;
        System.out.println(itm + " removed from second stack.");
    }

    private void display() {
        System.out.print("First stack - ");
        for (int i = 0; i <= topLeft; i++)
            System.out.print(stackArray[i] + " ");
        System.out.println();
        System.out.print("Second array is - ");
        for (int i = MAX - 1; i >= topRight; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TwoStacksInOneArray twoStacksInOneArray = new TwoStacksInOneArray();
        twoStacksInOneArray.pushRight(60);
        twoStacksInOneArray.pushLeft(10);
        twoStacksInOneArray.pushRight(50);
        twoStacksInOneArray.pushRight(40);
        twoStacksInOneArray.pushRight(30);
        twoStacksInOneArray.pushLeft(20);

        twoStacksInOneArray.display();
        twoStacksInOneArray.popLeft();
        twoStacksInOneArray.popLeft();
        twoStacksInOneArray.popLeft();
        twoStacksInOneArray.display();

        twoStacksInOneArray.popRight();
        twoStacksInOneArray.popRight();

        twoStacksInOneArray.display();
    }
}
