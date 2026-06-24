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
    public ListNode reverse(ListNode cur) {
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode temp = head;

        while (temp != null) {
            tail.next = new ListNode(temp.val);
            tail = tail.next;
            temp = temp.next;
        }

        ListNode copy = dummy.next;

        copy = reverse(copy);
        temp = head;

        while (temp != null && copy != null) {
            if (temp.val != copy.val) {
                return false;
            }
            temp = temp.next;
            copy = copy.next;
        }

        return true;
    }
}