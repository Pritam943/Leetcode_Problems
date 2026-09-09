/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        if(head == null) return null;

        if(head.next == null) return head;

        ListNode slow = head;
        ListNode fast = slow.next;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.next;
    }
}