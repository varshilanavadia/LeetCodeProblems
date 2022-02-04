import java.util.Objects;

public class PalindromeLists {

    private boolean checkPalindrome(ListNode head) {
        ListNode revHead = reverseAndClone(head);
        return helper(head, revHead);
    }

    private ListNode reverseAndClone(ListNode node) {
        ListNode head = null;
        while(node != null){
            ListNode n = new ListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }

        return head;
    }

    private boolean helper(ListNode head, ListNode revHead) {
        if(head == null && revHead == null){
            return true;
        }

        if(head == null || revHead == null){
            return false;
        }

        if(!Objects.equals(head.val, revHead.val)){
            return false;
        }

        return helper(head.next, revHead.next);
    }

    public static void main(String[] args) {
        PalindromeLists object = new PalindromeLists();

        ListNode head = new CommonAlgorithms().createLinkedList(new int[]{1, 3, 1});
        head.printList();
        System.out.println(object.checkPalindrome(head));
    }
}
