/*
2021-Feb-05. Oleksii Saiun.
LeetCode_#142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/

Approach 1. Fast and Slow pattern

If we know the length of the LinkedList cycle, we can find the start of the cycle through the following steps:
 A) Initialize both pointers to point to the start(head) of the LinkedList.
 B) Move pointer2 ahead by ‘K’ nodes.
 C) Now, keep incrementing pointer1 and pointer2 until they both meet.
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
    private int LenOfLoop=0;
    public ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        boolean isLoop = checkIfIsLoop(slowPointer,fastPointer);
        System.out.println("loop: "+isLoop);
        
        if(isLoop)
        {
                ListNode pointer1 = head;
                ListNode pointer2 = head;
         return findBeginOfLoop(pointer1, pointer2, LenOfLoop);
        }
    return null;
}
    
    
    public boolean checkIfIsLoop(ListNode slowPointer, ListNode fastPointer)
    {
        while( fastPointer!=null && fastPointer.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            
            if(fastPointer==slowPointer)
            {
                LenOfLoop = calcLengthOfLoop(slowPointer);
                return true;
            }
        }  
        return false;
    }
    
    public int calcLengthOfLoop(ListNode slowPointer)
    {
        ListNode loopPointer=slowPointer;
        loopPointer=loopPointer.next;
        int counter=1;
        while(slowPointer!=loopPointer)
        {
            loopPointer=loopPointer.next;
            //System.out.println("loopPointer.val:"+loopPointer.val+"; slowPointer.val:"+slowPointer.val);
            counter++;
        }
       return counter;         
    }

    public ListNode findBeginOfLoop(ListNode pointer1, ListNode pointer2, int lengthCounter)
    {
    // move pointer2 to [length] steps forward:
        while(lengthCounter>0)
        {
         pointer2=pointer2.next;
         lengthCounter=lengthCounter-1;
        }
        
        //two pinters will match at the beginning of loop
        while(pointer1!=pointer2)
        {
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }

        return pointer1;
    }    
}
