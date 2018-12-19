package com.leetcode.popularAlgos;

import com.leetcode.utility.TreeNode;

public class NearestInteger {

    public TreeNode getNearestInteger(TreeNode root, TreeNode nearestRoot, int num, int diff){
        if(root == null) return nearestRoot;
        if(root.val == num) {
            diff = 0;
            return root;
        }
        else if(root.val > num) {
            nearestRoot = (root.val - num < diff) ? root : nearestRoot;
            diff = (root.val - num < diff) ? root.val - num : diff;
        }
        else {
            nearestRoot = (num- root.val < diff) ? root : nearestRoot;
            diff = (num - root.val < diff) ? num - root.val : diff;
        }
        if(root.val >= num){
            return getNearestInteger(root.left, nearestRoot, num, diff);
        }
        else{
            return getNearestInteger(root.right, nearestRoot, num, diff);
        }
    }


    public static void main(String[] args) {
            NearestInteger NI = new NearestInteger();
            TreeNode  root = new TreeNode(25);
            root.setLeft(new TreeNode(15));
            root.setRight(new TreeNode(35));
            TreeNode left = root.left;
            TreeNode right = root.right;
            left.setRight(new TreeNode(20));
            right.setRight(new TreeNode(55));
            TreeNode nearestNode = null;
            System.out.println(NI.getNearestInteger(root, nearestNode, 10, Integer.MAX_VALUE).val);
    }
}
