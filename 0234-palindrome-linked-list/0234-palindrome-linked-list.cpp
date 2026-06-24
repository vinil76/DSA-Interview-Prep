/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public: 
    ListNode* reverseList(ListNode* &head){
        ListNode* prev = NULL;

        while(head != NULL){
            ListNode* next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
    bool isPalindrome(ListNode* head) {
        if(head == NULL || head->next == NULL){
            return true;
        }

        ListNode* slow = head;
        ListNode* fast = head;
        while(fast != NULL && fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* second = reverseList(slow);
        ListNode* first = head;

        while(second != NULL){
            if(first->val != second->val){
                return false;
            }

            first = first->next;
            second = second->next;
        }

        return true;
    }
};