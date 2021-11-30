package com.deep.datastructure.tree.binaryTree;

public class DistanceBetweenTwoNodesInBinarySearchTree {

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
        }else if(root.key > key) {
            root.left = insert(root.left, key);
        }else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static int findDistanceFromRoot(Node root, int x) {
        if (root.key == x) {
            return 0;
        } else if (root.key > x) {
            return 1 + findDistanceFromRoot(root.left, x);
        }
        return 1 + findDistanceFromRoot(root.right, x);

    }

    static int findDistanceBetweenNodes(Node root, int a, int b) {
        if (root == null) {
            return 0;
        }

        if (root.key > a && root.key > b) {
            return findDistanceBetweenNodes(root.left, a, b);
        }

        if (root.key < a && root.key < b) {
            return findDistanceBetweenNodes(root.right, a, b);
        }

        if (root.key >= a && root.key <= b) {
            return findDistanceFromRoot(root, a) + findDistanceFromRoot(root, b);
        }
        return 0;
    }

    static int findDistance(Node root, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return findDistanceBetweenNodes(root, a, b);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 30);
        insert(root, 25);
        insert(root, 35);

        System.out.println("Distance between nodes = " + findDistance(root, 25, 35));
    }

}
