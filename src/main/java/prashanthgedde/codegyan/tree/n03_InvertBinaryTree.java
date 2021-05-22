package prashanthgedde.codegyan.tree;

/**
 * 226. Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Easy
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *
 * Input:
 *               4
 *             /   \
 *           /      \
 *          2        7
 *        /   \    /  \
 *       1    3   6    9
 *
 * Output:
 *               4
 *             /   \
 *           /      \
 *          7        2
 *        /   \    /  \
 *       9    6   3    1
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */

public class n03_InvertBinaryTree {

    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if(root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);
        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }


}
