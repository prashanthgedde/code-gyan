package prashanthgedde.codegyan.tree;

public class n01_HeightOfBTree {

    public static int height(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1+Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        System.out.println(height(node)); //1

        node.left = new BinaryTreeNode(2);
        System.out.println(height(node));  //2

        node.right = new BinaryTreeNode(3);
        System.out.println(height(node));  //2

        node.right.left = new BinaryTreeNode(4);
        System.out.println(height(node));  //3

        node.right.left.left = new BinaryTreeNode(5);
        System.out.println(height(node));  //4

        node.right.left.left.left = new BinaryTreeNode(6);
        System.out.println(height(node));  //5
    }
}
