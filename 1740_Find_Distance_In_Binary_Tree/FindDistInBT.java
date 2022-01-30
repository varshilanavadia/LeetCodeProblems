public class FindDistInBT {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLca(root, p, q);
        return calcDistance(lca, p, 0) + calcDistance(lca, q, 0);
    }

    private TreeNode findLca(TreeNode node, int p, int q){
        if(node == null){
            return null;
        }
        if(node.value == p || node.value == q){
            return node;
        }

        TreeNode left = findLca(node.left, p, q);
        TreeNode right = findLca(node.right, p, q);

        if(left != null && right != null){
            return node;
        } else if (left != null){
            return left;
        } else {
            return right;
        }
    }

    private int calcDistance(TreeNode node, int p, int distance){
        if(node == null){
            return -1;
        }

        if(node.value == p){
            return distance;
        }

        int left = calcDistance(node.left, p, distance+1);
        if(left == -1){
            return calcDistance(node.right, p, distance+1);
        }
        return left;

    }
}
