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
    static class Pair {
        int key;
        ListNode value;

        public Pair(int key, ListNode value) {
            this.key = key;
            this.value = value;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.key, b.key));

        for (int i = 0; i < lists.length; i++) {

            // FIX: Only read .val if the current list head is NOT null
            if (lists[i] != null) {
                minHeap.add(new Pair(lists[i].val, lists[i])); // Fixed capital 'P'
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!minHeap.isEmpty()) {

            Pair p = minHeap.peek();
            temp.next = p.value;

            minHeap.poll();

            ListNode nElement = p.value.next;

            if (nElement != null) {
                minHeap.add(new Pair(nElement.val, nElement));
            }

            temp = temp.next;

        }

        return dummy.next;

    }
}