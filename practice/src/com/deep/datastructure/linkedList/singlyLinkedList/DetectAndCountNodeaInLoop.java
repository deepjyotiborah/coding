package com.deep.datastructure.linkedList.singlyLinkedList;

/*
    Traverse linked list using two pointers. Move one pointer(slow_p) by one and another pointer(fast_p) by two
    If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
 */

public class DetectAndCountNodeaInLoop extends SinglyLinkedList {
    private void detectLoop() {
        Node slow_Ptr = head, fast_Ptr = head;

        while (slow_Ptr != null && fast_Ptr!= null && fast_Ptr.next != null) {
            slow_Ptr = slow_Ptr.next;
            fast_Ptr = fast_Ptr.next.next;

            if(slow_Ptr == fast_Ptr) {
                System.out.println("Loop detected.");
                countNodesInLoop(slow_Ptr);
                return;
            }
        }

        System.out.println("No loop detected.");
    }

    private void countNodesInLoop(Node node_Ptr) {
        Node temp = node_Ptr;
        int res = 1;
        while (temp.next != node_Ptr) {
            temp = temp.next;
            res++;
        }

        System.out.println("No. of nodes in loop are - " + res);
    }

    public static void main(String[] args) {
        DetectAndCountNodeaInLoop detectLoopInList = new DetectAndCountNodeaInLoop();
        detectLoopInList.append(20);
        detectLoopInList.append(4);
        detectLoopInList.append(15);
        detectLoopInList.append(10);

        //Creating a loop
        head.next.next.next = head;

        detectLoopInList.detectLoop();
    }
}
