/*
2021-Feb-15. Oleksii Saiun.
LeetCode_#206. Reverse Linked List.
https://leetcode.com/problems/reverse-linked-list/

Approach2. Reverse on a fly
*/

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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode reversedLinkedList = new ListNode(head.val);
        head=head.next;
        
        while(head!=null)
        {
            ListNode newNode = new ListNode(head.val);
            newNode.next=reversedLinkedList;
            reversedLinkedList=newNode;

            head=head.next;
        }
        
        return reversedLinkedList;
    }
}
