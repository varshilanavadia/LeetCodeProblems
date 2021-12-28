import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode297 root) {
        if(root == null){
            return "X";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }


    public TreeNode297 deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));

        return deserializeHelper(queue);
    }

    private TreeNode297 deserializeHelper(Queue<String> queue){
        String node = queue.poll();

        if(node.equals("X")){
            return null;
        }

        TreeNode297 root = new TreeNode297(Integer.parseInt(node));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}