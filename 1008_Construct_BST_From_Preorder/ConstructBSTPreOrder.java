public class ConstructBSTPreOrder {
    private int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int left, int right){
        if(index == preorder.length){
            return null;
        }

        int current = preorder[index];

        if(current < left || current > right){
            return null;
        }

        index++;
        TreeNode root = new TreeNode(current);
        root.left = helper(preorder, left, current);
        root.right = helper(preorder, current+1, right);
        return root;
    }
}
