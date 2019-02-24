package com.leetcode.popularAlgos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayFormOfInteger {
	
	public static List<Integer> addToArrayForm(int[] A, int K) {
        if(K == 0) return Arrays.stream(A).boxed().collect(Collectors.toList());
        LinkedList<Integer> digits = findDigits(K);
        LinkedList<Integer> output = new LinkedList<>();
        int carry = 0;
        if(A.length > digits.size()){
            int kIter = digits.size()-1;
            for(int i = A.length-1; i>=0; i--){
                int count = (kIter >=0) ? A[i] + digits.get(kIter--) + carry : A[i] + carry;
                carry = (count >= 10) ? 1 : 0;
                count = (count >= 10) ? count% 10 : count;
                output.addFirst(count);
            }
            if(carry > 0) output.addFirst(carry);
            return (List<Integer>) output;
        }else{
            int AIter = A.length -1;
            for(int i= digits.size()-1; i >= 0; i--){
                int count = (AIter >= 0) ? digits.get(i) + A[AIter--] + carry : digits.get(i) + carry ;
                carry = (count >= 10) ? 1: 0;
                count = (count >= 10) ? count%10 : count;
                output.addFirst(count);
            }
            if(carry > 0) output.addFirst(carry);
            return (List<Integer>) output;
        }
    }
    
    private static LinkedList<Integer> findDigits(int K){
        LinkedList<Integer> digits = new LinkedList<>();
        while(K >0){
           digits.addFirst(K%10);
           K = K/10; 
        }
        return digits;
    }
    
    
    public static void main(String[] args) {
    	int[] nums1 = new int[] {1,2,3};
    	int[] nums2 = new int[] {1,2,3};
    	int[] nums3 = new int[] {9,9,9};
    	
    	ArrayFormOfInteger.addToArrayForm(nums3, 10).stream().forEach(System.out::print);
    }

}
