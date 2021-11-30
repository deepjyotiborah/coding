package com.deep.datastructure.tree.binaryTree.trversals;

import com.deep.datastructure.tree.binaryTree.BinaryTree;

public class InorderWithoutRecursionAndStack {
    private void inorder(BinaryTree.Node root) {
        BinaryTree.Node cur, pre = null;
        if (root == null)
            return;
        cur = root;

        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.key + " ");
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    System.out.println(cur.key);
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.getNode(1);
        binaryTree.root.left = binaryTree.getNode(2);
        binaryTree.root.left.left = binaryTree.getNode(3);
        binaryTree.root.left.right = binaryTree.getNode(4);
        binaryTree.root.right= binaryTree.getNode(5);
        binaryTree.root.right.right= binaryTree.getNode(6);

        InorderWithoutRecursionAndStack obj = new InorderWithoutRecursionAndStack();
        obj.inorder(binaryTree.root);

    }
}
