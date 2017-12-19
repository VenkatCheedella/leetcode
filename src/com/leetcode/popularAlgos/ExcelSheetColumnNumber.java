package com.leetcode.popularAlgos;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		 if (s == null)
				return -1;
			char[] sChars = s.toCharArray();

			// check invalid chars in the string
			for (char c : sChars) {
				int valOfChar = c;
				if (valOfChar < 65 || valOfChar > 90) {
					return -1;
				}
			}
			if (sChars.length == 1)
				return sChars[0] - 64;
			int multiplier = 26;
			int totalVal = sChars[sChars.length - 1] -64;
			for (int i = sChars.length - 2; i != -1; i--) {
				totalVal += multiplier * (sChars[i] - 64);
				multiplier *= 26;
			}
			return totalVal;
	}

	public static void main(String[] args) {
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZZZ"));
	}
}
