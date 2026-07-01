/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            ListNode startingpoint= head;

            if (slow == fast){
               while(startingpoint != slow){
                startingpoint =startingpoint.next;
                slow=slow.next;
               }
               return startingpoint;
            }
        }
        return null;
    }
}