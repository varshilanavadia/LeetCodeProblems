public class SumLists {

    private ListNode sumOfLists1(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        int carry = 0;
        while(list1 != null || list2 != null){
            int x = list1 != null ? list1.val : 0;
            int y = list2 != null ? list2.val : 0;
            int sum = x + y + carry;

            dummy.next = new ListNode(sum % 10);
            carry = sum/10;

            if(list1 != null){
                list1 = list1.next;
            }
            if(list2 != null){
                list2 = list2.next;
            }

            dummy = dummy.next;
        }

        if(carry > 0){
            dummy.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        SumLists object = new SumLists();
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode list1 = new CommonAlgorithms().createLinkedList(new int[]{7, 1, 6});
        ListNode list2 = new CommonAlgorithms().createLinkedList(new int[]{5, 9, 2});
        object.sumOfLists1(list1, list2).printList();

        list1 = new CommonAlgorithms().createLinkedList(new int[]{6, 1, 7});
        list2 = new CommonAlgorithms().createLinkedList(new int[]{2, 9, 5});
        ListNode list1Rev = reverseLinkedList.reverseList(list1);
        ListNode list2Rev = reverseLinkedList.reverseList(list2);
        reverseLinkedList.reverseList(object.sumOfLists1(list1Rev, list2Rev)).printList();
    }

}
