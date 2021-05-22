package prashanthgedde.codegyan.tree.BST;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * Easy
 *
 * Given the root of a binary search tree (BST) with duplicates,
 *  return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 *          1
 *           \
 *            \
 *            2
 *           /
 *          /
 *         2
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 */

import prashanthgedde.codegyan.tree.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class n02_ModeInBST {
    public int[] findMode(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();

        _solve(root, list);

        int[] ret = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    BinaryTreeNode prev = null;
    int bigModCount = 0;
    int modCount = 0;
    private void _solve(BinaryTreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        _solve(node.left, list);
        if(prev == null) {
            prev = node;
            modCount = 1;
            list.add(node.val);
        }
        else if(prev.val == node.val) {
            // extend
            modCount++;
        }
        else {
            //reset
            prev = node;
            modCount = 1;
        }

        if(modCount > bigModCount) {
            bigModCount = modCount;
            list.clear();
            list.add(node.val);
        }
        else if(modCount == bigModCount) {
            list.add(node.val);
        }

        _solve(node.right, list);
    }

    public static void main(String[] args) {
        n02_ModeInBST bst = new n02_ModeInBST();

        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(9);
        System.out.println(Arrays.toString(bst.findMode(root)));
    }

}
