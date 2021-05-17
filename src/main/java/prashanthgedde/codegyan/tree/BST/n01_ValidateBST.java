package prashanthgedde.codegyan.tree.BST;

import prashanthgedde.codegyan.tree.BinaryTreeNode;

public class n01_ValidateBST {

    public static boolean isValidBST(BinaryTreeNode root) {
        // METHOD-1: recursive check with MIN, MAX thresholds
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // METHOD-2: TODO: recursive check with MIN, MAX for any object
        // can we use null check and generic comparison of objects?

        // METHOD-3: TODO: Can we use in-order traversal of tree and check if its in
        // ascending order. If the order breaks any time we can fail the check.
    }

    // METHOD-1: recursive check with MIN, MAX thresholds
    private static boolean _isValidBST(BinaryTreeNode node, long min, long max) {
        if(node == null) return true;

        return (node.val > min && node.val < max) &&
                _isValidBST(node.left, min, node.val) &&
                _isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(9);
        System.out.println(n01_ValidateBST.isValidBST(root));

        root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(9);
        System.out.println(n01_ValidateBST.isValidBST(root));
    }
}
