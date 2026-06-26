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
        List<Integer> ans = new ArrayList<>();
        ListNode temp = head;

        while(temp != null){
            ans.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy  = new ListNode(0);
        ListNode cur = dummy;
        Collections.sort(ans);

        for(int val:ans){
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }


        return dummy.next;        
    }
}