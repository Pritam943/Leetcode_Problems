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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode curr = head;
        int size = 1;

        while (curr.next != null) {
            size++;
            curr = curr.next;
        }

        k = k % size;
        if (k == 0) {
            return head;
        }

        curr.next = head;

        int len = size - k;
        ListNode temp = head;

        for (int i = 1; i < len; i++) {

            temp = temp.next;
        }

        ListNode new_head = temp.next;
        temp.next = null;

        return new_head;
    }
}