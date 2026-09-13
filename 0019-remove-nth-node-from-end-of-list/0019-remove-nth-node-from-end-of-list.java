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

        if (head.next == null)
            return null;

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        if (count == n)
            return head.next;

        curr = head;
        int k = 0;

        while (k < count - n - 1) {
            curr = curr.next;
            k++;
        }

        if (curr.next == null || curr.next.next == null) {
            curr.next = null;
        } else {
            curr.next = curr.next.next;
        }

        return head;
    }
}