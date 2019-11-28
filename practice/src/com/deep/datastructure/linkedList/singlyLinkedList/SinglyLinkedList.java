package com.deep.datastructure.linkedList.singlyLinkedList;

import com.sun.glass.events.mac.NpapiEvent;

public class SinglyLinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private void insertBeginning(int value) {
        if(head == null) {
            head = new Node(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    private void append(int value) {
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

    private void displayList() {
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
        singlyLinkedList.append(60);
        singlyLinkedList.insertBeginning(5);
        singlyLinkedList.insertBeginning(20);
        singlyLinkedList.displayList();
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
