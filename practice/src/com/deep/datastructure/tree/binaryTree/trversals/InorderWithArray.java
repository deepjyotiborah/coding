package com.deep.datastructure.tree.binaryTree.trversals;

public class InorderWithArray {
    public static void main(String[] args) {
        ArrayImpl arrayImpl = new ArrayImpl();
        arrayImpl.Root("A");
        arrayImpl.insertLeft("B", 0);
        arrayImpl.insertRight("D", 1);
        arrayImpl.insertLeft("C", 1);
        arrayImpl.insertLeft("E", 2);

        arrayImpl.printTree();
    }
}

class ArrayImpl {
    static String[] arr = new String[10];
    static int root = 0;

    public void Root(String key) {
        arr[0] = key;
    }

    public void insertLeft(String key, int parent) {
        int t = (parent * 2) + 1;
        if (arr[parent] == null) {
            System.out.println("Can't insert as parent is null.");
        } else {
            arr[t] = key;
        }
    }

    public void insertRight(String key, int parent) {
        int t = (parent * 2) + 2;
        if (arr[parent] == null) {
            System.out.println("Can't insert as parent is null.");
        } else {
            arr[t] = key;
        }
    }

    public void printTree() {
        for (int i = 0; i < 10; i++) {
            if (arr[i] != null) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print("-");
            }
        }
    }

}
