import java.util.*;

public class CodecNary {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node node, StringBuilder sb){
        if(node == null){
            sb.append("#").append(",");
        } else {
            sb.append(node.val).append(",");
            sb.append(node.children.size()).append(",");
            for(Node child: node.children){
                serializeHelper(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        System.out.println(data);
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue){
        String current = queue.poll();
        if(current.equals("#")){
            return null;
        }

        int numChildren = Integer.parseInt(queue.poll());
        Node root = new Node(Integer.parseInt(current), new ArrayList<Node>());
        for(int i = 0; i < numChildren; i++){
            root.children.add(deserializeHelper(queue));
        }

        return root;
    }
}