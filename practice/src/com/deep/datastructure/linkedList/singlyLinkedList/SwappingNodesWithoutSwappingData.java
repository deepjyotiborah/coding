package com.deep.datastructure.linkedList.singlyLinkedList;

public class SwappingNodesWithoutSwappingData extends SinglyLinkedList {

    private void swapNodes(int x, int y) {
        if(x == y)
            return;

        Node prevX = null, curX = head;
        while (curX != null && curX.data != x) {
            prevX = curX;
            curX = curX.next;
        }

        Node prevY = null, curY = head;
        while (curY != null && curY.data != y) {
            prevY = curY;
            curY = curY.next;
        }

        if(curX == null || curY == null)
            return;

        if(prevX != null)
            prevX.next = curY;
        else
            head = curY;

        if(prevY != null)
            prevY.next = curX;
        else
            head = curX;

        //Swap next pointers
        Node temp = curX.next;
        curX.next = curY.next;
        curY.next = temp;
    }

    public static void main(String[] args) {
        SwappingNodesWithoutSwappingData swappingNodesWithoutSwappingData = new SwappingNodesWithoutSwappingData();
        swappingNodesWithoutSwappingData.append(10);
        swappingNodesWithoutSwappingData.append(20);
        swappingNodesWithoutSwappingData.append(30);
        swappingNodesWithoutSwappingData.append(40);
        swappingNodesWithoutSwappingData.append(50);
        swappingNodesWithoutSwappingData.displayList();
        swappingNodesWithoutSwappingData.swapNodes(20, 40);
        swappingNodesWithoutSwappingData.displayList();
        swappingNodesWithoutSwappingData.swapNodes(30, 50);
        swappingNodesWithoutSwappingData.displayList();
    }
}
