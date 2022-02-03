
public class Sol206 {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode head = new CommonAlgorithms().createLinkedList(new int[]{1, 2, 3, 4, 5});

        head.printList();
        reverseLinkedList.reverseList(head).printList();
    }
}
