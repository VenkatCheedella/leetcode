package com.leetcode.popularAlgos;

import java.util.HashMap;

public class MergeSort {
	
	
	public int[] mergeTwoIntegerArrays(int[] intA, int[] intB) {
		
		int[] resultArray = new int[intA.length + intB.length];
		int iterA = 0;
		int iterB = 0;
		int currentIter = 0;
		
		//Iter through the arrays
		while(iterA < intA.length && iterB < intB.length) {
			if(intA[iterA] <= intB[iterB]) {
				resultArray[currentIter++] = intA[iterA++];
			}
			else {
				resultArray[currentIter++] = intB[iterB++];
			}
		}
		
		// If the arrayA has larger intergers
		while(iterA < intA.length) {
			resultArray[currentIter++] = intA[iterA++];
		}
		
		// If the arrayB has larger integers
		while(iterB < intB.length) {
			resultArray[currentIter++] = intB[iterB++];
		}
		
		return resultArray;
	}
	
	public int[] mergeSort(int[] arrayOfInts) {
		
		if(arrayOfInts.length ==1) {
			return arrayOfInts;
		}
	
		int[] firstHalf = new int[arrayOfInts.length/2];
		for(int i=0; i<arrayOfInts.length/2; i++) {
			firstHalf[i] = arrayOfInts[i];
		}
		
		int remainingLen = arrayOfInts.length - arrayOfInts.length/2;
		int[] secondHalf = new int[remainingLen];
		for(int i = arrayOfInts.length/2, j=0; i < arrayOfInts.length; ++i, ++j) {
			secondHalf[j] = arrayOfInts[i];
		}
		
		return mergeTwoIntegerArrays(mergeSort(firstHalf), mergeSort(secondHalf));
		
	}
	
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] sortedArray = ms.mergeSort(new int[] {1,4,8,7,3,2,4,8,9,12,15,10});
		
		for(int i=0; i< sortedArray.length; ++i) {
			System.out.print(sortedArray[i] + "\t");	
		}
		HashMap<Integer, Integer> checkHashMap = new HashMap<>();
	}
}
