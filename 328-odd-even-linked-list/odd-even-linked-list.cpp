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
    ListNode* oddEvenList(ListNode* head) {
        if (head==nullptr) return nullptr;
        ListNode *oddhead=head->next;
        ListNode *temp=head;
        ListNode *temp1=head->next;
        while (temp1!=nullptr && temp1->next!=nullptr){
            temp->next=temp1->next;
            temp=temp->next;
            temp1->next=temp->next;
            temp1=temp1->next;
        }
        temp->next=oddhead;
        return head;
    }
};