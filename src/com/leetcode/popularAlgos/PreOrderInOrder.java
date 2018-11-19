package com.leetcode.popularAlgos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PreOrderInOrder {
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> idxPlaces = new HashMap<>();
        for(int i=0; i<preorder.length; i++) idxPlaces.put(inorder[i],i);
        return helper(preorder, inorder,0, preorder.length-1, idxPlaces);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> idxPlaces){
        if(preIdx > preorder.length-1){
            return null;
        }
        if(inStart > inEnd){
            --preIdx;
            return null;
        }
        TreeNode head = new TreeNode(preorder[preIdx]);
        int mid = idxPlaces.get(preorder[preIdx]);
        ++preIdx;
        head.left = helper(preorder, inorder, inStart, mid-1, idxPlaces);
        ++preIdx;
        head.right = helper(preorder, inorder, mid+1, inEnd, idxPlaces);
        return head;
    }

    public void printTreeLevelOrder(TreeNode tree){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree);
        q.add(null);
        while(!(q.peek() == null && q.size() == 1)){
            TreeNode currNode = q.poll();
            if(currNode == null) q.offer(null);
            else{
                System.out.print(currNode.val + "\t");
                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
            }
        }
    }

    public static void main(String[] args) {
        int [] pre = {1,2};
        int [] in = {1,2};
        PreOrderInOrder preOrderInOrderTest = new PreOrderInOrder();
        TreeNode node = preOrderInOrderTest.buildTree(pre, in);
        preOrderInOrderTest.printTreeLevelOrder(node);
    }
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
