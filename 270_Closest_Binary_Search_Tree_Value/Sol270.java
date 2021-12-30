public class Sol270 {
    public static void main(String[] args) {
        ClosestValueInBST1 closestValueInBST1 = new ClosestValueInBST1();

        TreeNode root = createTree();
        double target = 3.714286;
        System.out.println(closestValueInBST1.closestValue(root, target));


        ClosestValueInBST2 closestValueInBST2 = new ClosestValueInBST2();
        System.out.println(closestValueInBST2.closestKValues(root, target, 2));
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        return root;

    }
}
