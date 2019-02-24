package com.leetcode.popularAlgos;

public class MinimumCostForTickets {
	private int monthIdx = -1;
	private int weekIdx = -1;

	public int mincostTickets(int[] days, int[] costs) {
		int[] cost = new int[days.length];
		cost[0] = costs[0];
		int dayCost = 0;
		int weekCost = 0;
		int monthCost = 0;
		for (int i = 1; i < days.length; i++) {
			// calculation of day cost
			dayCost = cost[i - 1] + costs[0];
			weekCost = calculateWeekCost(days, costs[1], i, weekIdx, cost);
			monthCost = calculateMonthCost(days, costs[2], i, monthIdx, cost);
			cost[i] = minOfThreeNumbers(dayCost, weekCost, monthCost);
		}
		return cost[days.length - 1];
	}

	// sliding window to calculate if the week cost is considered
	private int calculateWeekCost(int[] days, int weekCost, int currIdx, int weekIdx, int[] cost) {
		if (weekIdx == -1 && days[currIdx] - days[0] <= 6)
			return weekCost;
		weekIdx = 0;
		while (days[currIdx] - days[weekIdx] > 6)
			weekIdx++;
		this.weekIdx = weekIdx;
		return cost[weekIdx - 1] + weekCost;

	}

	// calculation of month cost for the current month, sliding the monthIdx for
	// previous month value
	private int calculateMonthCost(int[] days, int monthCost, int currIdx, int monthIdx, int[] cost) {

		if (monthIdx == -1 && days[currIdx] - days[0] <= 29)
			return monthCost;
		monthIdx = 0;
		while (days[currIdx] - days[monthIdx] > 29)
			monthIdx++;
		this.monthIdx = monthIdx;
		return cost[monthIdx - 1] + monthCost;

	}

	private int minOfThreeNumbers(int a, int b, int c) {
		return (a < b) ? (a < c) ? a : c : (b < c) ? b : c;
	}

	public static void main(String[] args) {
		MinimumCostForTickets minCost = new MinimumCostForTickets();
		int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
		days = new int[] { 1,2,3,4,5,6,7,8,9,10,30,31};
		int[] costs = new int[] { 2, 7, 15 };
		System.out.println(minCost.mincostTickets(days, costs));
	}
}
