package com.deep.datastructure.linkedList.singlyLinkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromList extends SinglyLinkedList{

    private void removeDuplicates() {
        HashSet<Integer> hashSet = new HashSet<>();
        Node cur = head, prev = null;

        while (cur != null) {
            if(hashSet.contains(cur.data)) {
                prev.next = cur.next;
            } else {
                hashSet.add(cur.data);
                prev = cur;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromList removeDuplicatesFromList = new RemoveDuplicatesFromList();
        removeDuplicatesFromList.append(10);
        removeDuplicatesFromList.append(39);
        removeDuplicatesFromList.append(10);
        removeDuplicatesFromList.append(28);
        removeDuplicatesFromList.append(30);
        removeDuplicatesFromList.append(40);
        removeDuplicatesFromList.append(28);
        removeDuplicatesFromList.displayList();
        removeDuplicatesFromList.removeDuplicates();
        removeDuplicatesFromList.displayList();
    }
}
