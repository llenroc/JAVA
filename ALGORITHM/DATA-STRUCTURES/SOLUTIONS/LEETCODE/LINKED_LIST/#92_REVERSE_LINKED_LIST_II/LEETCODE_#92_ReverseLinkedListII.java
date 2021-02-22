/*
2021-Feb-21. Oleksii Saiun.
LeetCode_#92. Reverse Linked List II
https://leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(m==n)
        {
            return head;
        }
        
        int counter=1;        
        
        //keep the middle of linked list in the interval [m;n]. I use stack because we will reverse it
        Stack<Integer> stack = new Stack<>();
        
        //keep the right part of linked list
        Queue<Integer> queue = new LinkedList<>();       
        
        ListNode dummyLeftPart=new ListNode(-1);
        ListNode leftPart=dummyLeftPart;
        ListNode prevNode=null;
        
        dummyLeftPart.next=head;
        
        //1.Processing left part
        while(counter<m)
        {
            prevNode=head;
            head=head.next;
            counter++;
        }
         

        //2.Processing middle part - it will be reversing
        while (counter <= n)
        {
           stack.add(head.val); 
           head=head.next;
           counter++;
        }
        
        //3.Processing right part
        while (head!=null)
        {
           queue.add(head.val); 
           head=head.next;
        }

         ListNode reversedLink = createLink(stack,queue);

        //  if(m==1) - no need to skip left part. In this case we have output [reverse middle part] + [right part]
        if(m==1)
        {
           return reversedLink; // = [reverse middle part] + [right part]
        }        
        else
        {
         leftPart=prevNode;       
         leftPart.next=reversedLink; 
         return dummyLeftPart.next;   
        }

        
        
    }
    
    
    // it creates LinkedList from the middle and right part
    private ListNode createLink(Stack<Integer> stack,Queue<Integer> queue )
    {        
        ListNode firstNode = new ListNode(stack.pop());
        ListNode reversedList= firstNode;
        while( !stack.isEmpty() )
        {
          ListNode newNode = new ListNode(stack.pop());  
          firstNode.next=newNode;
          firstNode=firstNode.next;          
        }
        
        while( !queue.isEmpty() )
        {
          ListNode newNode = new ListNode(queue.poll());  
          firstNode.next=newNode;
          firstNode=firstNode.next;          
        }
        return reversedList;
    }
}
