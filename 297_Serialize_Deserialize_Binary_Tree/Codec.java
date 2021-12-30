import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        if(root == null){
            return "X";
        }

        return root.value + "," + serialize(root.left) + "," + serialize(root.right);
    }


    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue){
        String node = queue.poll();

        if(node.equals("X")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}