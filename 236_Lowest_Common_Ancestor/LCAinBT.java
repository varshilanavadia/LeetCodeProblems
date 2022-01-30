import java.util.HashSet;
import java.util.Set;

public class LCAinBT {

    // BINARY SEARCH TREE (235)
    public TreeNode lowestCommonAncestorInBST(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.value;
        int pVal = p.value;
        int qVal = q.value;

        if(pVal > rootVal && qVal > rootVal){
            return lowestCommonAncestorInBST(root.right, p, q);
        } else if(pVal < rootVal && qVal < rootVal){
            return lowestCommonAncestorInBST(root.left, p, q);
        } else {
            return root;
        }
    }

    // LCA IN BT 1 AND 2 (236, 1644)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        } else if (left != null){
            return left;
        } else {
            return right;
        }
    }

    // LCA IN BT 4 (1676)
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for(TreeNode node: nodes){
            set.add(node.value);
        }
        dfs(root, set);
        return lca;
    }

    private int dfs(TreeNode node, Set<Integer> set){
        if(node == null){
            return 0;
        }

        int leftCount = dfs(node.left, set);
        int rightCount = dfs(node.right, set);
        int total = leftCount + rightCount;

        if(set.contains(node.value)){
            total++;
        }


        if(total == set.size() && lca == null){
            lca = node;
        }

        return total;
    }

}
