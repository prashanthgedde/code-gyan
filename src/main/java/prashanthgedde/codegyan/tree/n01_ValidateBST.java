package prashanthgedde.codegyan.tree;

public class n01_ValidateBST {

    public static boolean isValidBST(BinaryTreeNode root) {
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

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
