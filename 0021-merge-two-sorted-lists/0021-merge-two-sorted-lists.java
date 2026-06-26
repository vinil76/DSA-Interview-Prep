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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;


        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                ListNode node1 = new ListNode(temp1.val);
                cur.next = node1;
                cur = cur.next;

                temp1 = temp1.next;
            }else{
                ListNode node2 = new ListNode(temp2.val);
                cur.next = node2;
                 cur = cur.next;

                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
            ListNode node1 = new ListNode(temp1.val);
            cur.next = node1;
             cur = cur.next;

            temp1 = temp1.next;
        }

        while(temp2 != null){
            ListNode node2 = new ListNode(temp2.val);
            cur.next = node2;
             cur = cur.next;
             
            temp2 = temp2.next;
        }


        return dummy.next;       
    }
}