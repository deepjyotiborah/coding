package com.deep.datastructure.tree.binaryTree.trversals;

import com.deep.datastructure.tree.binaryTree.BinaryTree;

public class DepthFirstSearch_DFS {

    private void preOrder(BinaryTree.Node node) {

        if (node == null)
            return;

        System.out.print(node.key + " ");

        preOrder(node.left);

        preOrder(node.right);
    }

    private void postOrder(BinaryTree.Node node) {

        if(node == null)
            return;

        postOrder(node.left);

        postOrder(node.right);

        System.out.print(node.key + " ");
    }

    private void inOrder(BinaryTree.Node node) {

        if(node == null) {
            return;
        }

        inOrder(node.left);

        System.out.print(node.key + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.getNode(1);
        binaryTree.root.left = binaryTree.getNode(2);
        binaryTree.root.right = binaryTree.getNode(3);
        binaryTree.root.left.left = binaryTree.getNode(4);
        binaryTree.root.left.right = binaryTree.getNode(5);

        DepthFirstSearch_DFS depthFirstSearch = new DepthFirstSearch_DFS();
        System.out.println("PostOrder - " );
        depthFirstSearch.postOrder(binaryTree.root);
        System.out.println();
        System.out.println("Pre Order - ");
        depthFirstSearch.preOrder(binaryTree.root);
        System.out.println();
        System.out.println("Inorder - ");
        depthFirstSearch.inOrder(binaryTree.root);
    }
}
