package com.leetcode.utility;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.leetcode.unittest.TestAnagrams;



public class RunTests {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestAnagrams.class);
		for(Failure f : result.getFailures()) {
			System.out.println(f.toString());
		}
	}
}
