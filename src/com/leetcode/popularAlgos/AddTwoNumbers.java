package com.leetcode.popularAlgos;

public class AddTwoNumbers {
	
	@SuppressWarnings("unused")
	private ListNode flushList(ListNode currentNode , ListNode leftOverListNode, int buffer) {
		
		//base case
		if(leftOverListNode == null) {
			if(buffer == 1) {
				currentNode.next = new ListNode(1);
			}
			return currentNode;
		}
		
		leftOverListNode.val = (buffer == 1) ? leftOverListNode.val+1  :leftOverListNode.val;
		buffer =0;
		if(leftOverListNode.val > 9) {
			leftOverListNode.val = leftOverListNode.val%10;
			buffer = 1;
		}
		currentNode.next = leftOverListNode;
		return flushList(currentNode.next, leftOverListNode.next, buffer);
	}
	
	
	// Consider l1 = 2, 3, 4
	// l2 = 3, 4, 5
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		if(l1 == null && l2 == null) {
			return result;
		}
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		ListNode currentNode = null;
		int buffer =0;
		do {
			int nodeValue = l1.val + l2.val + buffer;
			
			//If integer greater than 10
			if(nodeValue > 9) {
				nodeValue = nodeValue %10;
				buffer = 1;
			}else {
				buffer = 0;
			}
			ListNode newNode =  new ListNode(nodeValue);
			if(result == null) {
				result = newNode;
				currentNode = newNode;
			}
			else {
				currentNode.next = newNode;
				currentNode = currentNode.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}while((l1 != null && l2 != null));
		
		if(l1 == null && l2 == null) {
			if(buffer == 1) {
				currentNode.next = new ListNode(1);
			}
		}
		else if(l1 == null) {
			currentNode = flushList(currentNode, l2, buffer);
		}else {
			currentNode = flushList(currentNode, l1, buffer);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] list1Nums = new int[] {9,8};
		int[] list2Nums = new int[] {1};
		
		
		ListNode l1 = new ListNode(list1Nums[0]);
		ListNode l1Head = l1;
		l1.next = new ListNode(list1Nums[1]);
//		l1 = l1.next;
//		l1.next = new ListNode(list1Nums[2]);
//		l1 = l1.next;
//		l1.next = new ListNode(list1Nums[3]);
		ListNode l2 = new ListNode(list2Nums[0]);
		ListNode l2Head = l2;
//		l2.next = new ListNode(list2Nums[1]);
//		l2 = l2.next;
//		l2.next = new ListNode(list2Nums[2]);
		
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode sum = addTwoNumbers.addTwoNumbers(l1Head, l2Head);
		while(sum != null) {
			System.out.print(sum.val + "->");
			sum = sum.next;
		}


 	}
	

}

class ListNode{
	ListNode next = null;
	int val;
	ListNode(int val){
		this.val =val;
	}
}