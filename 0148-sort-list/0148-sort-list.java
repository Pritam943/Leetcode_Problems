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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode mid = findMid(head);

        ListNode left_head = head;
        ListNode right_head = mid.next;
        mid.next = null;

        ListNode left = sortList(left_head);
        ListNode right = sortList(right_head);

        return mergeSort(left, right);

    }

    public ListNode mergeSort(ListNode headA, ListNode headB) {

        ListNode left = headA;
        ListNode right = headB;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {

                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        while (left != null) {

            temp.next = left;
            temp = left;
            left = left.next;
        }

        while (right != null) {

            temp.next = right;
            temp = right;
            right = right.next;
        }

        return dummy.next;

    }

    public ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}