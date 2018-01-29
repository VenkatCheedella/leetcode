package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class SearchAStringIn2DGrid {

	private static boolean validIndex(char[][] grid, int i, int j) {
		return (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length);
	}

	public static List<Integer> searchAStringInGrid(char[][] grid, String word) {
		// consecutive integers are start and end indices of each occurance of a word
		List<Integer> indices = new ArrayList<>();

		int matchIndex = 0;

//		// find in a row right side direction
//		for (int i = 0; i < grid.length; i++) {
//			matchIndex = 0;
//			for (int j = 0; j < grid[0].length; j++) {
//				if (validIndex(grid, i, j)) {
//					if (word.charAt(matchIndex) == grid[i][j]) {
//						++matchIndex;
//					}
//				} else {
//					break;
//				}
//				// if there is a match
//				if (matchIndex == word.length()) {
//					indices.add(i);
//					indices.add(j - (word.length() - 1));
//					indices.add(i);
//					indices.add(j);
//					matchIndex = 0;
//				}
//			}
//		}

		// find in a column down word direction
		for (int j = 0; j < grid[0].length; j++) {
			matchIndex = 0;
			for (int i = 0; i < grid.length; i++) {
				if (validIndex(grid, i, j)) {
					if (word.charAt(matchIndex) == grid[i][j]) {
						++matchIndex;
					}
				} else {
					break;
				}
				// if there is a match
				if (matchIndex == word.length()) {
					indices.add(i - (word.length() - 1));
					indices.add(j);
					indices.add(i);
					indices.add(j);
					matchIndex = 0;
				}
			}
		}

//		// find in a column in upward direction
//		for (int j = 0; j < grid[0].length; j++) {
//			matchIndex = 0;
//			for (int i = grid.length - 1; i >= 0; i--) {
//				if (validIndex(grid, i, j)) {
//					if (word.charAt(matchIndex) == grid[i][j]) {
//						++matchIndex;
//					}
//				} else {
//					break;
//				}
//				// if there is a match
//				if (matchIndex == word.length()) {
//					indices.add(i + (word.length() - 1));
//					indices.add(j);
//					indices.add(i);
//					indices.add(j);
//					matchIndex = 0;
//				}
//			}
//		}

		return indices;
	}

	public static void main(String[] args) {
		char[] row1 = { 'g', 'e', 'e', 'g', 'e' };
		char[] row2 = { 'q', 'u', 'i', 'z', 's' };
		char[] row3 = { 's', 'k', 'e', 'e', 'g' };
		char[][] newGrid = new char[][] { row1, row2, row3 };
		// System.out.println(newGrid[0].length);
		// System.out.println(newGrid.length);
		System.out.println(SearchAStringIn2DGrid.searchAStringInGrid(newGrid, "ge"));
	}
}
