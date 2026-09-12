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
    public ListNode oddEvenList(ListNode head) {
        //Brute force

        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){
            
            list.add(curr.val);
            curr = curr.next;
        }
  
        ListNode prev = head;

        for(int i=1; i<list.size(); i++){

             if((i+1)%2 != 0){
                  ListNode temp = new ListNode(list.get(i));
                  prev.next = temp;
                  prev = temp;
             }
        }

        for(int i=1; i<list.size(); i++){

             if((i+1)%2 == 0){
                  ListNode temp = new ListNode(list.get(i));
                  prev.next = temp;
                  prev = temp;
             }
        }

        return head;
    }
}