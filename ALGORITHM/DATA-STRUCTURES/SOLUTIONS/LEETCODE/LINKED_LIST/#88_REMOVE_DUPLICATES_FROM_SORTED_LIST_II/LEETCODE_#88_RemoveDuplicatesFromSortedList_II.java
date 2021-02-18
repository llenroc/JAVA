/*
2021-Feb-18. Oleksii Saiun.
LeetCode_#82. Remove Duplicates from Sorted List II
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
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

import java.util.Map.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        LinkedHashMap<Integer,Integer> outMap = populateMapOnlyDistinctNodes(head);
        ListNode dummyNode = new ListNode(-1);
        ListNode lastNode = dummyNode;
        for(Entry<Integer,Integer> entry : outMap.entrySet())
        {
            int key=entry.getKey();
            int freq=entry.getValue();
            
            if(freq==1)
            {
                //move pointer to the last node
                ListNode newNode = new ListNode(key);
                
                while(lastNode.next!=null)
                {
                    lastNode=lastNode.next;
                }
                lastNode.next=newNode;
            }
        }
        return dummyNode.next;
    }
    
    private LinkedHashMap<Integer,Integer> populateMapOnlyDistinctNodes(ListNode head)
    {
        LinkedHashMap<Integer,Integer> outMap = new LinkedHashMap<>();
        
        while(head!=null)
        {
           int key=head.val;
           int currFreq=outMap.getOrDefault(key,0);
           outMap.put(key,currFreq+1);
           head=head.next;
        }
      return outMap;
    }
}
