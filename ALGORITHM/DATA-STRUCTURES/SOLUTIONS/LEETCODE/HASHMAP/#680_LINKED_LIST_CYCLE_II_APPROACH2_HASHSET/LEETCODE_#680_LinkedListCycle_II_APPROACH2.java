/*
2021-Feb-24. Oleksii Saiun.
LeetCode_#142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/
Approach 2. HashSet
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
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        while(head!=null)
        {
            boolean flag = set.add(head);
            if(!flag)
            {
                return head; 
            }
            
            head=head.next;
        }
        
        return null;
    }
}
