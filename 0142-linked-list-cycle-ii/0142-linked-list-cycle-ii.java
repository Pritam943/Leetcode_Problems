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

        if(head == null) return null;

        if(head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        ListNode start = head;
        
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null) return null;
    
        while(start != slow){
            start = start.next;
            slow = slow.next;
        }

        return start;

    }
}