package com.deep.datastructure.linkedList.singlyLinkedList;

public class NoOfTimesGivenNumberInList extends SinglyLinkedList{
    public static void main(String[] args) {
       NoOfTimesGivenNumberInList noOfTimesGivenNumberInList = new NoOfTimesGivenNumberInList();
       noOfTimesGivenNumberInList.append(10);
        noOfTimesGivenNumberInList.append(20);
        noOfTimesGivenNumberInList.append(30);
        noOfTimesGivenNumberInList.append(10);
        noOfTimesGivenNumberInList.append(30);
        noOfTimesGivenNumberInList.append(10);
        System.out.println(" Number of times element 10 present in list is - "+
                noOfTimesGivenNumberInList.findNoOfTimesElementPresentInList(head, 10));
    }

    private int findNoOfTimesElementPresentInList(Node head,int num) {
        if(head == null)
            return 0;
        if (head.data == num)
            return 1 + findNoOfTimesElementPresentInList(head.next, num);
        return findNoOfTimesElementPresentInList(head.next, num);
    }
}
