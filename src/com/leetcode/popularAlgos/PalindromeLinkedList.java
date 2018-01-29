package com.leetcode.popularAlgos;

public class PalindromeLinkedList {
	
	public static ListNode reverseList(ListNode head, ListNode tail) {
		if (head == null) {
			return tail;
		}
		ListNode plcHolder = head.next;
		head.next = tail;
		return reverseList(plcHolder, head);
	}
	
	public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        
        if(head.next == null){
            return true;
        }
        
        //find the second half
        ListNode slowIter = head;
        ListNode fastIter = head;
        ListNode secondHalf = null;
        
        while(fastIter != null){
            fastIter = fastIter.next;
            if(fastIter == null){
            		slowIter = slowIter.next;
                break;
            }
            fastIter = fastIter.next;
            slowIter = slowIter.next;
        }
        
        // reverse the second half of the linked list
        secondHalf = reverseList(slowIter, null);
        
        while(secondHalf != null){
            if(head.val == secondHalf.val){
                head = head.next;
                secondHalf = secondHalf.next;
            }else{
                return false;
            }
        }
        return true;
    }
	
	public synchronized void   sampleMethod() {
		
	}
	
	
	public static void main(String[] args) {
		int[] valArray = new int[] {1,2,1,2,1};
		ListNode head = null;
		ListNode tail = head;
		for(int i=0; i< valArray.length; ++i) {
			if(head == null) {
				head = new ListNode(valArray[i]);
				tail = head;
			}
			else {
				tail.next = new ListNode(valArray[i]);
				tail = tail.next;
			}
		}
		System.out.println("Is input valid palindrome : " + isPalindrome(head));
		String strins = new String("New Thread" + 5);
		System.out.println(strins);
	}
}
