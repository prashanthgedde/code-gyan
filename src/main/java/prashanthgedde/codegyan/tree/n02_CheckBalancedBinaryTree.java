package prashanthgedde.codegyan.tree;

public class n02_CheckBalancedBinaryTree {

    class Int {
        public int val;
        public Int(int val){ this.val = val;}
    }

    public boolean check(BinaryTreeNode node) {
        Int height = new Int(0);
        return _check(node, height);
    }

    private boolean _check(BinaryTreeNode node, Int height) {
        if(node == null) {
            return true;
        }

        Int leftHeight = new Int(0);
        Int rightHeight = new Int(0);
        boolean leftBalanced = _check(node.left, leftHeight);
        boolean rightBalanced = _check(node.right, rightHeight);

        height.val = 1+Math.max(leftHeight.val, rightHeight.val);
        //System.out.println("Height at node: "+node.val+": "+height.val);
        if(Math.abs(leftHeight.val-rightHeight.val) > 1) {
            return false;
        }
        return leftBalanced && rightBalanced;
    }

    public static void main(String[] args) {
        n02_CheckBalancedBinaryTree obj = new n02_CheckBalancedBinaryTree();

        BinaryTreeNode node = new BinaryTreeNode(1);
        System.out.println(obj.check(node)); //true

        node.left = new BinaryTreeNode(2);
        System.out.println(obj.check(node));  //true

        node.right = new BinaryTreeNode(3);
        System.out.println(obj.check(node));  //true

        node.right.left = new BinaryTreeNode(4);
        System.out.println(obj.check(node));  //true

        node.right.left.left = new BinaryTreeNode(5);
        System.out.println(obj.check(node));  //false

        node.right.left.left.left = new BinaryTreeNode(6);
        System.out.println(obj.check(node));  //false
    }
}
