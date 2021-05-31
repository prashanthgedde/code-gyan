package prashanthgedde.codegyan.tree;

import java.util.LinkedList;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */

import java.util.*;

public class n04_FromPreAndInorder {
    private int preIndex = 0;

    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return _helper(preorder, inorder, 0, preorder.length-1);
    }

    private BinaryTreeNode _helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(inStart > inEnd || preIndex >= preorder.length) return null;

        // Find next node to be the root from preorder
        int val = preorder[preIndex++];
        BinaryTreeNode node = new BinaryTreeNode(val);

        // Based on this root node, split the inorder into two halves one for left subtree and other for right.
        int inPos = findInorderIndex(val, inorder, inStart, inEnd);

        // recursively invoke rest of tree building
        node.left = _helper(preorder, inorder, inStart, inPos-1);
        node.right = _helper(preorder, inorder, inPos+1, inEnd);

        // return the constructed treenode
        return node;
    }

    private int findInorderIndex(int val, int []inorder, int inStart, int inEnd) {
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private static void printLevelOrder(BinaryTreeNode root) {
        if(root == null) return;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {

            List<BinaryTreeNode> list = new ArrayList<>();
            while(!q.isEmpty()) {
                BinaryTreeNode node = q.poll();
                list.add(node);
                System.out.print(node.val+" ");
            }
            System.out.println("");
            for(BinaryTreeNode node: list) {
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        n04_FromPreAndInorder obj = new n04_FromPreAndInorder();
        printLevelOrder(obj.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
