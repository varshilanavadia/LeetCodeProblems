public class DLLNode{
    Node head, tail;
    int length;

    public DLLNode(){
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.length = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.length--;
    }

    public Node removeLast(){
        Node node = this.tail.prev;
        if(node != head){
            deleteNode(node);
            return node;
        }
        return null;
    }

    public void addNode(Node node){
        node.prev = this.head.next.prev;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;

        this.length++;
    }
}