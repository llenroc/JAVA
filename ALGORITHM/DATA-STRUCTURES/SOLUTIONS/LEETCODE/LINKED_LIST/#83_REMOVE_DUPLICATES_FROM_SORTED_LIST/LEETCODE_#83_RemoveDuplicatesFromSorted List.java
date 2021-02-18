/*
2021-Feb-15. Oleksii Saiun.
LeetCode_#83. Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = populateSet(head);
        ListNode dummy = new ListNode(-1);
        Iterator<Integer> iter=set.iterator();
        while(iter.hasNext())
        {
            int newValue = iter.next();
       //     System.out.println(newValue);
            ListNode newNode = new ListNode(newValue);  
 
            ListNode lastNode = dummy;
            while(lastNode.next!=null)
            {
                lastNode=lastNode.next;
            }
            lastNode.next=newNode;
        }

        return dummy.next;
    }
    
    private HashSet<Integer> populateSet(ListNode head)
    {
        HashSet<Integer> set = new LinkedHashSet<>();
        while(head!=null)
        {
            set.add(head.val);
            head=head.next;
        }
        return set;
    }
}
