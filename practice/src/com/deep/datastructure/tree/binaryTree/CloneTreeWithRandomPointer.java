package com.deep.datastructure.tree.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class CloneTreeWithRandomPointer {

    private Node cloneLeftRight(Node node, Map<Node,Node> cloneMap) {
        if (node == null)
            return null;

        cloneMap.put(node, new Node(node.key));
        cloneMap.get(node).left = cloneLeftRight(node.left, cloneMap);
        cloneMap.get(node).right = cloneLeftRight(node.right, cloneMap);

        return cloneMap.get(node);
    }

    private Node cloneRandomPointer(Node node, Map<Node, Node> cloneMap) {
        if(node == null)
            return null;

        cloneMap.get(node).random = node.random;
        cloneRandomPointer(node.left, cloneMap);
        cloneRandomPointer(node.right, cloneMap);
        return cloneMap.get(node);
    }

    private void printInorder(Node root) {
        if(root ==  null)
            return;
        printInorder(root.left);
        String randomKey = root.random != null ? String.valueOf(root.random.key) : null;
        System.out.print(root.key + " " + "Random" + randomKey +" ");

        printInorder(root.right);
    }

    public static void main(String[] args) {
        //Test No 1
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.random = tree.left.right;
        tree.left.left.random = tree;
        tree.left.right.random = tree.right;

        //  Test No 2
        //    tree = NULL;

        //  Test No 3
        //    tree = new Node(1);

        //  Test No 4
    /*    tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.random = tree.right;
        tree.left.random = tree;
    */

        CloneTreeWithRandomPointer  cloneTreeWithRandomPointer = new CloneTreeWithRandomPointer();
        System.out.println( "Inorder traversal of original binary tree is: \n");
        cloneTreeWithRandomPointer.printInorder(tree);

        Node clone = cloneTreeWithRandomPointer.cloneTree(tree);

        System.out.println( "\n\nInorder traversal of cloned binary tree is: ");
        cloneTreeWithRandomPointer.printInorder(clone);


    }

    private Node cloneTree(Node tree) {
        if (tree == null)
            return null;
        Map<Node, Node> cloneMap = new HashMap<>();
        Node newTree = cloneLeftRight(tree, cloneMap);
        newTree = cloneRandomPointer(tree, cloneMap);
        return newTree;
    }
}

class Node {
    int key;
    Node right, left;
    Node random;

    public Node(int key) {
        this.key = key;
    }
}
