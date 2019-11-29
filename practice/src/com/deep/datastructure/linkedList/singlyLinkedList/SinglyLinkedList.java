package com.deep.datastructure.linkedList.singlyLinkedList;

import com.sun.glass.events.mac.NpapiEvent;

public class SinglyLinkedList {

    protected static  Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    protected void insertBeginning(int value) {
        if(head == null) {
            head = new Node(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    protected void append(int value) {
        if(head == null) {
            head = new Node(value);
            return;
        }

        Node newNode = new Node(value);

        Node cur = head;
        while (cur.next != null)
            cur = cur.next;

        cur.next = newNode;
    }

    private void deleteNode(int value) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head.data == value) {
            head = head.next;
            return;
        }

        Node cur = head, prev = null;
        while (cur != null && cur.data != value) {
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            return;

        prev.next = cur.next;
    }

    private void deleteAtPosition(int position) {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }

        if(position == 0) {
            head = head.next;
            return;
        }

        Node cur = head, prev = null;
        for (int i = 0; i < position - 1 && cur!= null; i++) {
            prev = cur;
            cur = cur.next;
        }

        if(cur==null)
            return;
        prev.next = cur.next;
    }

    /*
    Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
    When the fast pointer reaches end slow pointer will reach middle of the linked list.
     */
    private void printMiddleElementMethod1() {
        Node slow_Ptr = head;
        Node fast_Ptr = head;


        while (fast_Ptr != null && fast_Ptr.next != null) {
            fast_Ptr = fast_Ptr.next.next;
            slow_Ptr = slow_Ptr.next;
        }

        System.out.println("Mid element by method1 is - " + slow_Ptr.data);
    }

    private void printMiddleElementMethod2() {
        Node cur = head;
        Node mid = head;
        int count = 0;
        while (cur != null) {
            if(count % 2 !=0) {
                mid = mid.next;
            }
            count++;
            cur = cur.next;
        }

        System.out.println("Mid element by method2 is " + mid.data);
    }

    protected void displayList() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(10);
        singlyLinkedList.append(30);
        singlyLinkedList.append(50);
        //singlyLinkedList.append(60);
        singlyLinkedList.insertBeginning(5);
        singlyLinkedList.insertBeginning(20);
        singlyLinkedList.displayList();
        singlyLinkedList.printMiddleElementMethod1();
        singlyLinkedList.printMiddleElementMethod2();
        singlyLinkedList.deleteNode(5);
        singlyLinkedList.displayList();
        singlyLinkedList.deleteAtPosition(5);
        singlyLinkedList.displayList();
        singlyLinkedList.deleteAtPosition(3);
        singlyLinkedList.displayList();
        singlyLinkedList.deleteAtPosition(0);
        singlyLinkedList.displayList();
    }
}
