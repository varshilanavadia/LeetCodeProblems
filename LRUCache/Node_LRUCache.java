public class Node_LRUCache {
    Integer key, value;
    Node_LRUCache next, prev;

    public Node_LRUCache(Integer key, Integer value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
