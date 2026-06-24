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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;

        ListNode fast = head,slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;

            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;

        return dummy.next;        
    }
}