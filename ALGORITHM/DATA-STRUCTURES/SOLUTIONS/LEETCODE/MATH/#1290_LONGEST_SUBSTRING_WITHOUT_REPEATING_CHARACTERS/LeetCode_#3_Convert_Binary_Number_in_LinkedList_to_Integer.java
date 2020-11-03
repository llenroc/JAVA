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

/*
2020-Nov-02. Oleksii Saiun.
LeetCode_#1290. Convert Binary Number in a Linked List to Integer
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/
*/   


class Solution {
    public int getDecimalValue(ListNode head) {
        int sizeOfList = getSize(head)-1;
        int sum=0;
        while(head!=null)
        {
            int pow =(int) Math.pow(2,sizeOfList--);
            sum = sum + head.val*pow;
            head=head.next;
        }
        
        return sum;
    }
    
    
     private int getSize(ListNode head)
    {
        int size=0;
        while(head!=null)
        {
            head=head.next;
            size=size+1;
            
        }
         return size;
    }

}
