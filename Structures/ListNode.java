public class ListNode {
     Integer val;
     ListNode next;

     ListNode() {
          val = null;
          next = null;
     }

     ListNode(Integer val) { this.val = val; }

     ListNode(Integer val, ListNode next) { this.val = val; this.next = next; }

     void printList() {
          System.out.print(this.val);
          if(this.next != null){
               System.out.print(" -> ");
               this.next.printList();
          } else {
               System.out.println();
          }
     }
 }
