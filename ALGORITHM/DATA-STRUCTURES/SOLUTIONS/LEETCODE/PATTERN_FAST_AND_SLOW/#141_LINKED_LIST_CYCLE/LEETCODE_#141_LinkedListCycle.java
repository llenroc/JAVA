/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#141. Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/

Approach 1. Fast and Slow pattern
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while(fastPointer!=null && fastPointer.next!=null)
        {
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
            
            if(slowPointer==fastPointer)
            {
                return true;
            }
        }
        
        return false;
    }
}
