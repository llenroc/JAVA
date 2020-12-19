/*
2020-Dec-18. Oleksii Saiun.
LeetCode_#23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/
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
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    
    public ListNode mergeKLists(ListNode[] lists) {
        populateHeap(lists);

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;
        
        while(!heap.isEmpty())
        {
           ListNode newNode = new ListNode(heap.poll()); 
            System.out.println(newNode.val);
            dummy.next=newNode;
            dummy=dummy.next;
        }

        return head.next;
    }
    
    public void populateHeap(ListNode[] lists)
    {
        for(int j=0; j<lists.length; j++)
        {
            while(lists[j]!=null)
            {
                int currVal = lists[j].val;
                heap.offer(currVal);
                lists[j]=lists[j].next;
            }
        }
    }
    public void displayList(ListNode list)
    {
        while(list!=null)
        {
            System.out.print(list.val+" ");
            list=list.next;
        }
        System.out.println();
    }
    

}
