import java.util.ArrayList;
import java.util.List;

public class LeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        dfs(root, result);

        return result;
    }

    private int dfs(TreeNode node, List<List<Integer>> result){
        if(node == null)
            return -1;

        int hLeft = dfs(node.left, result);
        int hRight = dfs(node.right, result);


        int currHeight = Math.max(hLeft, hRight) + 1;
        for(int i = result.size(); i < currHeight + 1; i++){
            result.add(new ArrayList<Integer>());
        }
        result.get(currHeight).add(node.value);

        return currHeight;
    }
}