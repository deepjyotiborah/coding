package com.deep.datastructure.tree.binaryTree.trversals;

import com.deep.datastructure.tree.binaryTree.BinaryTree;

import java.util.Stack;

public class InorderWithoutRecursion {

    private void inorder(BinaryTree.Node root) {
        
        BinaryTree.Node cur = root;
        Stack<BinaryTree.Node> nodeStack = new Stack();
        while (cur != null || nodeStack.size() > 0) {
            while (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            }
            cur = nodeStack.pop();
            System.out.print(cur.key + " ");
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.getNode(1);
        binaryTree.root.left = binaryTree.getNode(2);
        binaryTree.root.left.left = binaryTree.getNode(3);
        binaryTree.root.left.right = binaryTree.getNode(4);
        binaryTree.root.right = binaryTree.getNode(5);
        binaryTree.root.right.right = binaryTree.getNode(6);

        InorderWithoutRecursion inorderWithoutRecursion = new InorderWithoutRecursion();
        System.out.println("Inorder traversal - ");
        inorderWithoutRecursion.inorder(binaryTree.root);
    }
}
