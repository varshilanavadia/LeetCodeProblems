public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}