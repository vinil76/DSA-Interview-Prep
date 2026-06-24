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
    public ListNode reverse(ListNode head){
        ListNode prev =  null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if(head == null){
            return head;
        }

        head = reverse(head);
        ListNode temp = head;
        int max = head.val;


        while(temp.next != null){
            if(temp.next.val < max){
                temp.next = temp.next.next;
            }else{
                max = temp.next.val;
                temp = temp.next;
            }
        }

        return reverse(head);
    }
}