package com.leetcode.unittest;

import org.junit.Assert;
import org.junit.Test;

import com.leetcode.popularAlgos.CheckAnagrams;


public class TestAnagrams {
	
	@Test
	public void testValidAnagrams() {
		CheckAnagrams checkanagrams = new CheckAnagrams();
		Assert.assertEquals(true, checkanagrams.isAnagram("anagram", "nagaram"));
	}
	
	@Test
	public void testInValidAnagrams() {
		CheckAnagrams checkanagrams = new CheckAnagrams();
		Assert.assertEquals(false, checkanagrams.isAnagram("car", "rat"));
	}
	
	@Test
	public void testNullStrings() {
		CheckAnagrams checkanagrams = new CheckAnagrams();
		Assert.assertEquals(false, checkanagrams.isAnagram("", ""));
	}
	
	
	@Test
	public void testFirstNullStrings() {
		CheckAnagrams checkanagrams = new CheckAnagrams();
		Assert.assertEquals(false, checkanagrams.isAnagram("sample", ""));
	}
	
	@Test
	public void testSecondNullString() {
		CheckAnagrams checkanagrams = new CheckAnagrams();
		Assert.assertEquals(false, checkanagrams.isAnagram("", "sample"));
	}
	
	@Test
	public void testZCharInString() {
		CheckAnagrams checkanagrams = new CheckAnagrams();
		Assert.assertEquals(false, checkanagrams.isAnagram("anazgram", "anagramz"));
	}
	
}
