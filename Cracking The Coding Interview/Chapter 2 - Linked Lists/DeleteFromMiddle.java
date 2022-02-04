/**
 * CTCI 2.3
* Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily
* the exact middle) of a singly linked list, given only access to that node
*
* For e.g.
* input: delete node c from linked list a -> b -> c -> d -> e -> f
* output: a -> b -> d -> e -> f
*/

public class DeleteFromMiddle {

    private void deleteFromMiddle(ListNode nodeToDelete) {
        if(nodeToDelete == null || nodeToDelete.next == null){
            return;
        }

        ListNode temp = nodeToDelete.next;
        nodeToDelete.val = temp.val;
        nodeToDelete.next = temp.next;
    }

    public static void main(String[] args) {
        DeleteFromMiddle object = new DeleteFromMiddle();

        ListNode head = new CommonAlgorithms().createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.print("Whole List: ");
        head.printList();
        ListNode nodeToDelete = head;
        int i = 0;
        while(i < 3){
            nodeToDelete = nodeToDelete.next;
            i++;
        }
        System.out.print("Node to delete: ");
        nodeToDelete.printList();
        object.deleteFromMiddle(nodeToDelete);
        System.out.print("After deletion: ");
        head.printList();
    }
}
