/*
* Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater
* than or equal to x. (IMPORTANT: The partition element x can appear anywhere in the "right partition"; it does not need
* to appear between the left and right partitions. The additional spacing the example below indicates the partition.)
* Input: 3 -> 5 -> 8 ->5 -> 10 -> 2 -> 1, partition = 5
* Output: 3 -> 1 -> 2   ->  10 -> 5 -> 5 -> 8
 * */

public class PartitionList {
    private ListNode partitionList(ListNode head, int partition){
        ListNode lower, higher, lowerDummy, higherDummy;
        lower = new ListNode(-1);
        higher = new ListNode(-1);
        lowerDummy = lower;
        higherDummy = higher;

        while(head != null){
            ListNode nextNode = head.next;
            if(head.val < partition){
                lower.next = head;
                lower = lower.next;
            } else {
                higher.next = head;
                higher = higher.next;
            }
            head.next = null;
            head = nextNode;
        }

        lower.next = higherDummy.next;
        return lowerDummy.next;
    }

    public static void main(String[] args) {
        PartitionList object = new PartitionList();

        ListNode head = new CommonAlgorithms().createLinkedList(new int[]{3,5,8,5,10,2,1});
        head.printList();
        object.partitionList(head, 5).printList();

        head = new CommonAlgorithms().createLinkedList(new int[]{2, 1, 3});
        head.printList();
        object.partitionList(head, 5).printList();

        head = new CommonAlgorithms().createLinkedList(new int[]{2, 1, 3});
        head.printList();
        object.partitionList(head, 2).printList();
    }
}
