import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    Map<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.putIfAbsent(node, newNode);
        for(Node nghbr : node.neighbors){
            List<Node> nextNodes = newNode.neighbors;
            nextNodes.add(cloneGraph(nghbr));
        }
        return newNode;
    }

}
