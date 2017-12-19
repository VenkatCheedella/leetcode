package com.leetcode.popularAlgos;
import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.utility.TreeNode;

public class BinaryTreeMaxDepth {
	
	
	public int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> sibblings = new LinkedList<>();
		sibblings.add(root);
		sibblings.add(null);
		int maxDepth = 1;
		do {
			TreeNode currentNode = sibblings.poll();
			if(currentNode == null) {
				sibblings.add(currentNode);
				++maxDepth;
			}else {
				if(currentNode.left != null) {
					sibblings.add(currentNode.left);
				}
				if(currentNode.right != null) {
					sibblings.add(currentNode.right);
				}
			}
		}while(sibblings.size() > 1);
		return maxDepth;
	}
	
	public static void main(String[] args) {
		
		TreeNode father = new TreeNode(1);
//		TreeNode left = new TreeNode(2);
//		TreeNode right = new TreeNode(3);
//		father.left = left;
//		father.right = right;
		System.out.println(new BinaryTreeMaxDepth().maxDepth(father));
	}

}
