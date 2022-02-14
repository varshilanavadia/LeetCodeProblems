public class BalancedBinaryTree {
    // APPROACH 1 - NOT OPTIMAL
    public boolean isBalanced_1(TreeNode root){
        if(root == null){
            return true;
        }

        return isBalanced_1(root.left) && isBalanced_1(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode node) {
        if(node == null){
            return 0;
        }

        int leftSubTreeHeight = height(node.left);
        int rightSubTreeHeight = height(node.right);

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

    // APPROACH 2 - OPTIMAL USING OBJECTS
    class Height{
        private int height;
        private boolean isBalanced;

        public Height(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced_2(TreeNode root){
        return isBalancedHelper(root).isBalanced;
    }

    private Height isBalancedHelper(TreeNode node) {
        if(node == null){
            return new Height(0, true);
        }

        Height leftSubTree = isBalancedHelper(node.left);
        if(!leftSubTree.isBalanced){
            return  new Height(0, false);
        }

        Height rightSubTree = isBalancedHelper(node.right);
        if(!rightSubTree.isBalanced){
            return  new Height(0, false);
        }

        if(Math.abs(leftSubTree.height - rightSubTree.height) > 1){
            return new Height(0, false);
        }

        return new Height(Math.max(leftSubTree.height, rightSubTree.height) + 1, true);
    }
}
