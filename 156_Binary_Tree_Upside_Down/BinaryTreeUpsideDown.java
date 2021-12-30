public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null){
            return root;
        }

        TreeNode leftNode = root.left;
        root.left = null;

        TreeNode temp = upsideDownBinaryTree(leftNode);

        leftNode.left = root.right;
        root.right = null;

        leftNode.right = root;

        return temp;
    }
}