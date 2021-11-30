package com.deep.datastructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {
    static int findMaximumWidth(BinaryTree.Node root) {
        int maxWidth = 0;
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size  = queue.size();
            maxWidth = Math.max(maxWidth, queue.size());
            while (size-- > 0) {
                BinaryTree.Node temp = queue.remove();
                System.out.print(temp.key + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.getNode(1);
        tree.root.left = tree.getNode(2);
        tree.root.right = tree.getNode(3);
        tree.root.left.left = tree.getNode(4);
        tree.root.left.right = tree.getNode(5);
        tree.root.right.right = tree.getNode(8);
        tree.root.right.right.left = tree.getNode(6);
        tree.root.right.right.right = tree.getNode(7);
        System.out.println("Maximum width - " + findMaximumWidth(tree.root));
    }
}
