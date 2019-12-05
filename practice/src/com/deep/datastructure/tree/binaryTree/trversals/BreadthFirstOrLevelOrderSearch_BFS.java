package com.deep.datastructure.tree.binaryTree.trversals;

import com.deep.datastructure.tree.binaryTree.BinaryTree;

public class BreadthFirstOrLevelOrderSearch_BFS {
    private int getHeight(BinaryTree.Node root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight > rightHeight)
            return 1 + leftHeight;
        return 1 + rightHeight;
    }

    private void traverse_BFS(BinaryTree.Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if(level > 1) {
            traverse_BFS(root.left, level - 1);
            traverse_BFS(root.right, level - 1);
        }
    }

    private void printBfsOrder(BinaryTree.Node root) {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            traverse_BFS(root, i);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.getNode(1);
        binaryTree.root.left = binaryTree.getNode(2);
        binaryTree.root.right = binaryTree.getNode(3);
        binaryTree.root.left.left = binaryTree.getNode(4);
        binaryTree.root.left.right = binaryTree.getNode(5);

        BreadthFirstOrLevelOrderSearch_BFS breadthFirstOrLevelOrderSearch_bfs = new BreadthFirstOrLevelOrderSearch_BFS();
        breadthFirstOrLevelOrderSearch_bfs.printBfsOrder(binaryTree.root);
    }
}
