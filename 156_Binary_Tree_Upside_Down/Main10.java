public class Main10 {
    public static void main(String[] args) {
        BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();
        CommonAlgorithms commonAlgorithms = new CommonAlgorithms();

        TreeNode root = createTree();
        System.out.println(commonAlgorithms.levelOrderTraversal(root));

        TreeNode upsideDownRoot = binaryTreeUpsideDown.upsideDownBinaryTree(root);
        System.out.println(commonAlgorithms.levelOrderTraversal(upsideDownRoot));

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
