package com.deep.datastructure.tree.binaryTree;

/*
    Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node corresponds to operand
 */

import java.util.Stack;

public class ExpressionTree {
    private BinaryTree.Node contructExpressionTree(char[] postfixExpr) {
        Stack<BinaryTree.Node> nodeStack = new Stack<>();
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node t, left, right;

        for (int i = 0; i < postfixExpr.length ; i++) {
            t = binaryTree.getNode(postfixExpr[i]);
            //If operand push into stack
            if(!isOperator(postfixExpr[i])) {
                nodeStack.push(t);
            } else { // Operator
                right = nodeStack.pop();
                left = nodeStack.pop();
                t.left = left;
                t.right = right;

                nodeStack.push(t);
            }
        }
        //return root element
        return nodeStack.pop();
    }

    private void inOrder(BinaryTree.Node node) {

        if(node == null) {
            return;
        }

        inOrder(node.left);

        System.out.print(Character.toString((char) node.key));

        inOrder(node.right);
    }

    private boolean isOperator(char ch) {
        if(ch == '+' || ch == '-' || ch == '*' || ch == '^' || ch == '/')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String postfixStr = "ab+ef*g*-";
        char[] postfixExpr = postfixStr.toCharArray();
        ExpressionTree expressionTree = new ExpressionTree();
        BinaryTree.Node root = expressionTree.contructExpressionTree(postfixExpr);
        System.out.println("Infix expression is - ");
        expressionTree.inOrder(root);
    }
}
