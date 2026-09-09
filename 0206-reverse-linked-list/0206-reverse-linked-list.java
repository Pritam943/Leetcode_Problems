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
    public ListNode reverseList(ListNode head) {
        return reverseUtil(null, head);
    }

    public ListNode reverseUtil(ListNode prev, ListNode curr){

         if(curr == null) return prev;

         ListNode Next = curr.next;
         curr.next = prev;

         return reverseUtil(curr, Next);
    }
}