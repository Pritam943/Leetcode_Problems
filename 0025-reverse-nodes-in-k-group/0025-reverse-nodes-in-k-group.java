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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            ListNode kthNode = getKthNode(temp, k);

            if (kthNode == null) {

                if (prev != null) {
                    prev.next = temp;
                    break;
                }
            } else {

                ListNode Next = kthNode.next;
                kthNode.next = null;

                reverseList(temp);

                if (temp == head) {
                    head = kthNode;
                } else {
                    prev.next = kthNode;
                }

                prev = temp;
                temp = Next;

            }
        }

        return head;

    }

    public ListNode getKthNode(ListNode head, int k) {

        ListNode temp = head;

        while (k - 1 != 0 && temp != null) {
            k--;
            temp = temp.next;
        }

        if (k - 1 == 0) {
            return temp;
        }

        return null;
    }

    public void reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
    }
}