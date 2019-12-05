package com.deep.datastructure.tree.binaryTree;

/*
    A tree is Continuous tree if in each root to leaf path, absolute difference between keys of two adjacent is 1.
 */

public class ContinuousTree {
    private boolean isContinuousTree(BinaryTree.Node root) {
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left == null)
            return  Math.abs(root.key - root.right.key) == 1 && isContinuousTree(root.right);

        if (root.right == null)
            return Math.abs(root.key - root.left.key) == 1 && isContinuousTree(root.left);

        return (Math.abs(root.key - root.left.key) == 1) && (Math.abs(root.key - root.right.key) == 1)
                && isContinuousTree(root.left)
                && isContinuousTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTree continiuousBinaryTree = new BinaryTree();
        continiuousBinaryTree.root = continiuousBinaryTree.getNode(3);
        continiuousBinaryTree.root.left = continiuousBinaryTree.getNode(2);
        continiuousBinaryTree.root.left.left = continiuousBinaryTree.getNode(1);
        continiuousBinaryTree.root.left.right = continiuousBinaryTree.getNode(3);
        continiuousBinaryTree.root.right = continiuousBinaryTree.getNode(4);
        continiuousBinaryTree.root.right.right = continiuousBinaryTree.getNode(5);
        ContinuousTree continuousTree = new ContinuousTree();
        System.out.println("Is continiuous binary tree - " + continuousTree.isContinuousTree(continiuousBinaryTree.root));

        BinaryTree noncontiniuousBinaryTree = new BinaryTree();
        noncontiniuousBinaryTree.root = noncontiniuousBinaryTree.getNode(3);
        noncontiniuousBinaryTree.root.left = noncontiniuousBinaryTree.getNode(2);
        noncontiniuousBinaryTree.root.left.left = noncontiniuousBinaryTree.getNode(8);
        noncontiniuousBinaryTree.root.left.right = noncontiniuousBinaryTree.getNode(3);
        noncontiniuousBinaryTree.root.right = noncontiniuousBinaryTree.getNode(4);
        noncontiniuousBinaryTree.root.right.right = noncontiniuousBinaryTree.getNode(5);
        ContinuousTree noncontinuousTree = new ContinuousTree();
        System.out.println("Is continiuous binary tree - " + noncontinuousTree.isContinuousTree(noncontiniuousBinaryTree.root));
    }
}
