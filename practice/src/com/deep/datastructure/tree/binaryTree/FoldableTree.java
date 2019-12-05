package com.deep.datastructure.tree.binaryTree;

/*
     tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other.
     An empty tree is considered as foldable
 */

public class FoldableTree {
    private boolean checkFoldable(BinaryTree.Node root) {
        if(root == null)
            return true;

        return isFoldable(root.left, root.right);
    }

    private boolean isFoldable(BinaryTree.Node node1, BinaryTree.Node node2) {

        /* If both left and right subtrees are NULL,
         then return true */
         if(node1 == null && node2 == null)
             return true;

         /* If one of the trees is NULL and other is not,
         then return false */
         if(node1 == null || node2 == null)
             return false;

         /* Otherwise check if left and right subtrees are mirrors of
         their counterparts */
         return isFoldable(node1.left, node2.right)
                 && isFoldable(node1.right, node2.left);
    }

    public static void main(String[] args) {
        BinaryTree foldableBinaryTree = new BinaryTree();
        foldableBinaryTree.root = foldableBinaryTree.getNode(1);
        foldableBinaryTree.root.left = foldableBinaryTree.getNode(2);
        foldableBinaryTree.root.right = foldableBinaryTree.getNode(3);
        foldableBinaryTree.root.left.right = foldableBinaryTree.getNode(4);
        foldableBinaryTree.root.right.left = foldableBinaryTree.getNode(5);

        FoldableTree foldableTree = new FoldableTree();
        System.out.println("Is foldable - " + foldableTree.checkFoldable(foldableBinaryTree.root));

        BinaryTree nonfoldableBinaryTree = new BinaryTree();
        nonfoldableBinaryTree.root = nonfoldableBinaryTree.getNode(1);
        nonfoldableBinaryTree.root.left = nonfoldableBinaryTree.getNode(2);
        nonfoldableBinaryTree.root.right = nonfoldableBinaryTree.getNode(3);
        nonfoldableBinaryTree.root.left.left = nonfoldableBinaryTree.getNode(4);
        nonfoldableBinaryTree.root.right.left = nonfoldableBinaryTree.getNode(5);
        System.out.println("Is foldable - " + foldableTree.checkFoldable(nonfoldableBinaryTree.root));
    }
}
