package com.leetcode.popularAlgos;

import com.leetcode.utility.ListNode;

public class DeleteListNode {
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
}
