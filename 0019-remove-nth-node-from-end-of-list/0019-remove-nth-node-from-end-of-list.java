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

        int count = 1;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        count = count - n;

        curr = head;
        ListNode prev = null;

        while (curr != null) {

            count--;

            if (count == 0) {
                if (prev == null)
                    return curr.next;
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}