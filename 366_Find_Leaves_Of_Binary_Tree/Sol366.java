public class Sol366 {
    public static void main(String[] args) {
        LeavesOfBinaryTree leavesOfBinaryTree = new LeavesOfBinaryTree();

        TreeNode root = createTree();

        System.out.println(leavesOfBinaryTree.findLeaves(root));
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        return root;

    }
}
