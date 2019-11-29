package com.deep.datastructure.linkedList.singlyLinkedList;
/*
      Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head.
  First, move reference pointer to n nodes from head. Now move both pointers one by one until the reference pointer reaches the end.
  Now the main pointer will point to nth node from the end. Return the main pointer.
*/

public class FindNthElementFromLast extends SinglyLinkedList{

    /*
   Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head.
First, move reference pointer to n nodes from head. Now move both pointers one by one until the reference pointer reaches the end.
Now the main pointer will point to nth node from the end. Return the main pointer.
*/
    private void printNthElementFromLast(int n) {
        Node ref_ptr =head, main_ptr = head;
        int count = 0;
        if(head != null) {
            while (count < n) {
                if(ref_ptr == null) {
                    System.out.println(n + " is greater than the no. of nodes in list.");
                }
                ref_ptr = ref_ptr.next;
                count++;
            }

            while (ref_ptr != null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no " + n + " from last is " + main_ptr.data);
        }
    }

    public static void main(String[] args) {
        FindNthElementFromLast findNthElementFromLast = new FindNthElementFromLast();
        findNthElementFromLast.append(10);
        findNthElementFromLast.append(20);
        findNthElementFromLast.append(30);
        findNthElementFromLast.append(40);
        findNthElementFromLast.append(50);

        findNthElementFromLast.displayList();
        findNthElementFromLast.printNthElementFromLast(2);
        findNthElementFromLast.printNthElementFromLast(4);
    }

}
