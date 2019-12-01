package com.deep.datastructure.stack;

public class QueueUsingStack {

    private Stack s1;
    private  Stack s2;

    public QueueUsingStack() {
        this.s1 = new Stack();
        this.s2 = new Stack();
    }

    private void enQueue(int item) {
        if(s1.isEmpty()) {
            s1.push(item);
            return;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(item);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    private void deQueue() {
        if(s1.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int itm = s1.pop();
        System.out.println(itm + " is removed from queue.");
    }

    private void display() {
        System.out.print("Queue is - ");
        s1.display();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.deQueue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.display();
        queue.deQueue();
        queue.display();

    }
}
