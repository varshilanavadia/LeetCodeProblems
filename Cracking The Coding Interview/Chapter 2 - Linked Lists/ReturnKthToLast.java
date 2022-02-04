/**
 * CTCI 2.2
 * Implement an algorithm to find the kth to last element og a singly linked list.
 */

public class ReturnKthToLast {

    public Integer findKthToLast(ListNode head, int k){
        ListNode slowRunner = head, fastRunner = head;
        while(k > 0){
            if(fastRunner == null){
                return null;
            }
            fastRunner = fastRunner.next;
            k--;
        }
        while(fastRunner != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return slowRunner.val;
    }


    public static void main(String[] args) {
        ReturnKthToLast object = new ReturnKthToLast();

        ListNode head = new CommonAlgorithms().createLinkedList(new int[]{4, 5, 2, 3, 7, 1, 8});
        head.printList();
        System.out.println(object.findKthToLast(head, 1));
        System.out.println(object.findKthToLast(head, 2));
        System.out.println(object.findKthToLast(head, 3));
        System.out.println(object.findKthToLast(head, 4));
        System.out.println(object.findKthToLast(head, 5));
        System.out.println(object.findKthToLast(head, 8));
    }
}
