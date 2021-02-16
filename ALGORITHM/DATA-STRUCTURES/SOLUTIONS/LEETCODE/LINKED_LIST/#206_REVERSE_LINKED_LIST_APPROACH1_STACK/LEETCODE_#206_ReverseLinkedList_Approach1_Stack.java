/*
2021-Feb-15. Oleksii Saiun.
LeetCode_#206. Reverse Linked List.
https://leetcode.com/problems/reverse-linked-list/

Approach1. Stack
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
        Stack<Integer> stack = populateStack(head);
        ListNode dummy = new ListNode(-1);
        head=dummy;

        while(!stack.isEmpty())
        {
           ListNode newNode = new ListNode(stack.pop());
           dummy.next=newNode;
           dummy=dummy.next;
          
        }
        return head.next;
    }
    
    private Stack<Integer> populateStack(ListNode head)
    {
      Stack<Integer> stackOut = new Stack<>();
        
      while(head!=null)
      {
          stackOut.add(head.val);
          head=head.next;
      }
        
        return stackOut;
    }
}
