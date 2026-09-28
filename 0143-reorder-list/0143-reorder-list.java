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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode curr2 = reverseList(secondHead);
        ListNode curr1 = head;
        ListNode prev = null;

        while (curr1 != null || curr2 != null) {

            ListNode Next1 = null;
            ListNode Next2 = null;

            if (curr1 != null) {
                Next1 = curr1.next;
            }
            if (curr2 != null) {
                Next2 = curr2.next;
            }

            if (prev != null) {
                prev.next = curr1;
            }
            curr1.next = curr2;
            prev = curr2;
            curr1 = Next1;
            curr2 = Next2;

        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        return prev;
    }
}