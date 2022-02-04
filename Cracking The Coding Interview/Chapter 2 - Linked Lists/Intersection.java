/**
 * Given two singly linked lists, determine if the two lists intersect. Return the intersecting node. Note that the
 * intersection is defined based on referece, not value. That is, if the kth node of the first linked list is the exact
 * same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */

public class Intersection {
    public ListNode getIntersection(ListNode headA, ListNode headB){
        ListNode p1 = headA, p2 = headB;

        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
