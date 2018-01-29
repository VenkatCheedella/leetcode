package com.leetcode.popularAlgos;

/**
 * It is a better way to use a while loop than looping in  a private method.
 * @author vcheedel
 *
 */
public class ReverseLinkedList {
	
	 private ListNode reverse(ListNode head, ListNode backIter){
	        if(head.next == null){
	            head.next = backIter;
	            return head;
	        }
	        else{
	            ListNode nextIter = head.next;
	            head.next = backIter;
	            return reverse(nextIter, head);
	        }
	    }
	    
	    public ListNode reverseList(ListNode head) {
	        if(head == null){
	            return head;
	        }
	        return reverse(head , null);
	    }
	    
}
