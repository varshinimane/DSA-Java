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
    public ListNode partition(ListNode head, int x) {
        ListNode b = new ListNode(0);
        ListNode a = new ListNode(0);
        ListNode b_curr = b;
        ListNode a_curr = a;

        while(head != null){
            if(head.val < x){
                b_curr.next = head;
                b_curr = b_curr.next;
            } else {
                a_curr.next = head;
                a_curr = a_curr.next;
            }
            head = head.next;
        }
        a_curr.next = null;
        b_curr.next = a.next;

        return b.next;
    }
}