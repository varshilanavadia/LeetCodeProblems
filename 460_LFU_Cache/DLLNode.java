public class DLLNode{
    Node_LFUCache head, tail;
    int length;

    public DLLNode(){
        this.head = new Node_LFUCache(null, null);
        this.tail = new Node_LFUCache(null, null);
        this.length = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void deleteNode(Node_LFUCache node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.length--;
    }

    public Node_LFUCache removeLast(){
        Node_LFUCache node = this.tail.prev;
        if(node != head){
            deleteNode(node);
            return node;
        }
        return null;
    }

    public void addNode(Node_LFUCache node){
        node.prev = this.head.next.prev;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;

        this.length++;
    }
}