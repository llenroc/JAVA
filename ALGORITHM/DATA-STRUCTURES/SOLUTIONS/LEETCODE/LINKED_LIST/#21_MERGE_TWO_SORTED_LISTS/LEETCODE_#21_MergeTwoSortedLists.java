/*
2020-Dec-18. Oleksii Saiun.
LeetCode_#21. Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/submissions/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {       
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;
        displayList(l2);
        while( l1!=null && l2!=null)
        {
            if (l1.val<l2.val)
            {
               dummy.next=l1;
               l1=l1.next;
            }
            else
            {
              dummy.next=l2;
               l2=l2.next;             
            }
            
            dummy=dummy.next;
        }

        if (l1!=null)
        {
            dummy.next=l1;
        }
        
        if(l2!=null)
        {
            dummy.next=l2;
        }

        return head.next;
    }
    
    public void displayList(ListNode list)
    {
        ListNode curr= list;
        
        while(curr!=null)
        {
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
            System.out.println();        
    }
}
