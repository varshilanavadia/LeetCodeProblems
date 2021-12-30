import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CommonAlgorithms {
    /*
    * LEVEL ORDER TRAVERSAL OF BINARY TREE - BREADTH FIRST SEARCH
    * */
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty() ) {
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                levels.get(level).add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }

    /*
    * INORDER TRAVERSAL OF BINARY TREE - DEPTH FIRST SEARCH
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    public void inorderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderHelper(root.left, res);
            res.add(root.val);
            inorderHelper(root.right, res);
        }
    }

    /*
     * PREORDER TRAVERSAL OF BINARY TREE - DEPTH FIRST SEARCH
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    public void preorderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorderHelper(root.left, res);
            preorderHelper(root.right, res);
        }
    }

    /*
     * POSTORDER TRAVERSAL OF BINARY TREE - DEPTH FIRST SEARCH
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    public void postorderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            postorderHelper(root.left, res);
            postorderHelper(root.right, res);
            res.add(root.val);
        }
    }
}
