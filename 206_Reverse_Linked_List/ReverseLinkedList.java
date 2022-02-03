public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode reverseHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }
}
