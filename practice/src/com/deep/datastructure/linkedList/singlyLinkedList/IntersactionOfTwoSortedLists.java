package com.deep.datastructure.linkedList.singlyLinkedList;

public class IntersactionOfTwoSortedLists{

    protected Node head;


    public  Node getHead() {
        return head;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node intersact(Node a, Node b) {
        if(a == null || b == null)
            return null;

        if(a.data < b.data)
            return intersact(a.next, b);

        if (a.data > b.data)
            return intersact(a, b.next);

        Node temp = new Node(0);
        temp.data = a.data;
        temp.next = intersact(a.next, b.next);
        return temp;
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

    public static void main(String[] args) {
        IntersactionOfTwoSortedLists intersactionOfTwoSortedLists1 = new IntersactionOfTwoSortedLists();
        intersactionOfTwoSortedLists1.append(10);
        intersactionOfTwoSortedLists1.append(20);
        intersactionOfTwoSortedLists1.append(30);
        intersactionOfTwoSortedLists1.append(40);
        intersactionOfTwoSortedLists1.append(70);

        IntersactionOfTwoSortedLists intersactionOfTwoSortedLists2 = new IntersactionOfTwoSortedLists();
        intersactionOfTwoSortedLists2.append(20);
        intersactionOfTwoSortedLists2.append(40);
        intersactionOfTwoSortedLists2.append(50);
        intersactionOfTwoSortedLists2.append(60);
        intersactionOfTwoSortedLists2.append(70);

        IntersactionOfTwoSortedLists intersactionOfTwoSortedLists3 = new IntersactionOfTwoSortedLists();
        Node temp = intersactionOfTwoSortedLists3.intersact(intersactionOfTwoSortedLists1.getHead(), intersactionOfTwoSortedLists2.getHead());
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
