package com.leetcode.popularAlgos;

import java.util.Stack;

public class MaximumRectangleArea {


    /**
     * Bsic idea is save left index with smaller height than current index and current index is consider as right index.
     * caluclate area for every index if you current index is smaller than previous index.
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> hists = new Stack<>();
        int maxArea = 0;

        // i <= heights.length , to calculate the area of remaining elements in the stack after the traverse of the array
        for(int i=0; i<= heights.length; i++){

            int height  = (i == heights.length) ? 0 : heights[i];

            if(hists.isEmpty() || heights[hists.peek()] <= height){
                hists.push(i);
            }
            else{
                int top = hists.pop();
                int topArea = (heights[top] * (hists.isEmpty() ? i : (i - 1 - hists.peek())));
                maxArea = Math.max(topArea, maxArea);
                --i;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {

        int[] heights = new int[]{2,1,5,6,2,3};
        MaximumRectangleArea mxArea = new MaximumRectangleArea();
        System.out.println(mxArea.largestRectangleArea(heights));

    }
}
