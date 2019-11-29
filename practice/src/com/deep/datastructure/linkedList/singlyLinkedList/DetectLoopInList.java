package com.deep.datastructure.linkedList.singlyLinkedList;

/*
    Traverse linked list using two pointers. Move one pointer(slow_p) by one and another pointer(fast_p) by two
    If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
 */

public class DetectLoopInList extends SinglyLinkedList {
    private void detectLoop() {
        Node slow_Ptr = head, fast_Ptr = head;

        while (slow_Ptr != null && fast_Ptr!= null && fast_Ptr.next != null) {
            slow_Ptr = slow_Ptr.next;
            fast_Ptr = fast_Ptr.next.next;

            if(slow_Ptr == fast_Ptr) {
                System.out.println("Loop detected.");
                return;
            }
        }

        System.out.println("No loop detected.");
    }

    public static void main(String[] args) {
        DetectLoopInList detectLoopInList = new DetectLoopInList();
        detectLoopInList.append(20);
        detectLoopInList.append(4);
        detectLoopInList.append(15);
        detectLoopInList.append(10);

        //Creating a loop
        head.next.next.next = head;

        detectLoopInList.detectLoop();
    }
}
