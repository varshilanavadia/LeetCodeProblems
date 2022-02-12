public class ValidateBST {

    // RECURSIVE APPROACH
    public boolean isValidBST_1(TreeNode root) {
        return validateBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBSTHelper(TreeNode node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.value <= min || node.value >= max){
            return false;
        }

        return validateBSTHelper(node.left, min, node.value) && validateBSTHelper(node.right, node.value, max);
    }

    // ITERATIVE APPROACH
    Integer prev;
    public boolean isValidBST_2(TreeNode root) {
        this.prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if(node == null){
            return true;
        }

        if(!inorder(node.left)){
            return false;
        }

        if(prev != null && node.value <= prev){
            return false;
        }

        prev = node.value;
        return inorder(node.right);
    }
}
