public class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}