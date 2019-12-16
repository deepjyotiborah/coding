package com.deep.datastructure.tree.binaryTree.trversals;

import com.deep.datastructure.tree.binaryTree.BinaryTree;

import java.util.Stack;

public class InorderWithoutRecursion {

    private void inorder(BinaryTree.Node root) {

        BinaryTree.Node cur = root;
        Stack<BinaryTree.Node> nodeStack = new Stack();
        while (cur != null || nodeStack.size() > 0) {
            /* Reach the left most Node of the curr Node */
            while (cur != null) {
                /* place pointer to a tree node on the stack before traversing the node's left subtree */
                nodeStack.push(cur);
                cur = cur.left;
            }

            /* Current must be NULL at this point */
            cur = nodeStack.pop();
            System.out.print(cur.key + " ");

            /* we have visited the node and its left subtree.  Now, it's right subtree's turn */
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
