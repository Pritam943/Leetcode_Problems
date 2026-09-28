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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode curr = head;

        while (curr != null) {

            count++;
            curr = curr.next;
        }

        if(count == n) return head.next;

        curr = head;
        int size = 0;

        while (size < count - n - 1) {
            curr = curr.next;
            size++;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        } else {
            curr.next = null;
        }

        return head;
    }
}