package com.deep.datastructure.tree.binaryTree;

public class BinaryTree {
    public Node root;

    public class Node {
        public int key;
        public Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public Node getNode(int key) {
        return new Node(key);
    }
}

