package com.leetcode.popularAlgos;

public class WildCardMatching {
	
	public static boolean isMatch(String s, String p) {
        if(s == null && p == null){
            return true;
        }
        
        if(p.equals("*") && (s == null || s.equals(""))){
            return true;
        }
        
        if(s == null || p == null){
            return false;
        }
        
        return helper(s, p, 0,0);
    }
    
    private static boolean helper(String s, String p, int i, int j){
        
        if(i >= s.length() && j >= p.length()){
            return true;
        }
        
        if(j >= p.length()) {
        		return false;
        }
        
        if(i >= s.length() && p.charAt(j) != '*'){
            return false;
        }
        
        if(p.charAt(j) == '*'){
            for(int curr = i; curr <= s.length(); ++curr){
                if(helper(s, p, curr, j+1)) {
                		return true;
                }
            }
            return false;
        }
        	
        if(p.charAt(j) == '?'){
            return helper(s, p, i+1, j+1);
        }
        
        if(s.charAt(i) != p.charAt(j)){
            return false;
        }
        
        return helper(s, p, i+1, j+1);
    }
    
    public static void main(String[] args) {
		System.out.println(WildCardMatching.isMatch("leetcode", "*e*t?d*"));
		System.out.println(WildCardMatching.isMatch("aa", "a"));
		int a =10;
		String sample = Integer.toString(a) + ":";
		System.out.println(sample);
		int b = 17;
		float s1 = a/b;
		float s2 = 100/170;
		if(s1 == s2) {
			System.out.println("Float values are same ");
		}
	}
}
