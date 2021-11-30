package com.deep.datastructure.tree.binaryTree;

public class DistanceBetweenTwoNodesInBinaryTree {
    public static BinaryTree.Node findLCA(BinaryTree.Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.key == n1 || root.key == n2) {
            return root;
        }

        BinaryTree.Node leftLca = findLCA(root.left, n1, n2);
        BinaryTree.Node rightLca = findLCA(root.right, n1, n2);

        if (leftLca != null && rightLca != null) {
            return  root;
        }

        if (leftLca != null) {
            return leftLca;
        }

        return rightLca;
    }

    private static int findLevel(BinaryTree.Node root, int a, int level) {
        if (root == null)
            return -1;

        if (root.key == a) {
            return level;
        }

        int left = findLevel(root.left, a, level+1);
        if (left == -1) {
            return findLevel(root.right, a , level+1);
        }
        return left;
    }

    private static int distanceBetweenTwoNodes(BinaryTree.Node root, int n1, int n2) {
        BinaryTree.Node lca = findLCA(root, n1, n2);
        int d1 = findLevel(lca, n1, 0);
        int d2 = findLevel(lca, n2, 0);

        return d1 + d2;
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

        System.out.println("Distance - " + distanceBetweenTwoNodes(tree.root, 2, 3));
    }
}
