import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity, size;
    Map<Integer, Node_LRUCache> map;
    Node_LRUCache head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap();
        this.head = new Node_LRUCache(null, null);
        this.tail = new Node_LRUCache(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node_LRUCache node = this.map.get(key);
        if(node != null){
            updatePerPolicy(node);
            return node.value;
        }
        return -1;
    }

    public java.lang.Integer put(int key, int value) {
        Node_LRUCache node = this.map.get(key);

        if(node != null){
            node.value = value;
            updatePerPolicy(node);
        } else {
            Node_LRUCache newNode = new Node_LRUCache(key, value);
            this.map.put(key, newNode);
            addToHead(newNode);
            size++;
            if(this.size > this.capacity){
                Node_LRUCache tailNode = deleteFromTail();
                this.map.remove(tailNode.key);
                size--;
            }
        }
        return null;
    }

    private Node_LRUCache deleteFromTail(){
        Node_LRUCache node = this.tail.prev;
        deleteNode(node);
        return node;
    }

    private void updatePerPolicy(Node_LRUCache node){
        deleteNode(node);
        addToHead(node);
    }

    private void deleteNode(Node_LRUCache node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node_LRUCache node){

        node.prev = this.head.next.prev;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }
}
