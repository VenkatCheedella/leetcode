package com.leetcode.popularAlgos;

public class BuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null) {
			return 0;
		}
		int total = 0;
		for (int i = 0; i < prices.length - 1; ++i) {
			if (prices[i] < prices[i + 1]) {
				total += (prices[i + 1] - prices[i]);
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		int[] stockprices = new int[] {4,5,3,1,7,2,10,6,1,5};
		System.out.println(new BuyAndSellStock().maxProfit(stockprices));
	}
}
