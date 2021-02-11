/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#876. Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/

Approach. Fast and Slow pattern
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
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while(fastPointer!=null && fastPointer.next!=null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
      return slowPointer;
    }
}
