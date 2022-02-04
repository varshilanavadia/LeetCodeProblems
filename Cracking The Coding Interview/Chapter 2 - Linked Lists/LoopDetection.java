/**
 * CTCI 2.8
 * Given a linked list which might contain a loop, implement an algorithm that return the node at the beginning
 * of the loop (if one exists)
 * For example,
 * Input : A -> B -> C -> D -> E -> C
 * Output : C
 */

public class LoopDetection {
    // part 1 - check if linked list has a cycle
    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // part 2 - return node where cycle begins
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode intersect = getIntersection(head);
        if(intersect == null){
            return null;
        }

        ListNode p1 = head;
        while(p1 != intersect){
            p1 = p1.next;
            intersect = intersect.next;
        }
        return p1;

    }

    private ListNode getIntersection(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }
}
