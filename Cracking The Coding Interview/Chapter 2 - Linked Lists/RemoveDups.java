import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list
 */

public class RemoveDups {
    public ListNode findDups(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        Set<Integer> set = new HashSet<>();
        while(dummy.next != null){
            if(set.contains(dummy.next.val)) {
                dummy.next = dummy.next.next;
                continue;
            }
            set.add(dummy.next.val);
            dummy = dummy.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDups object = new RemoveDups();


        ListNode head = new CommonAlgorithms().createLinkedList(new int[]{1, 5, 3, 7, 1, 5, 4});
        head.printList();
        object.findDups(head).printList();

        head = new CommonAlgorithms().createLinkedList(new int[]{-1,4,3,6,-1,4,-1,2,-4,1,2,4,1,24,2,1,2});
        head.printList();
        object.findDups(head).printList();

    }

}
