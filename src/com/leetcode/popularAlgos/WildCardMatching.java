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

    public static boolean isPatternMatch(String str, String pattern) {
        int s =0, p = 0, match = 0, strIdx = -1;

        while(s < str.length()) {
            if(p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')){
                ++s;
                ++p;
            }

            else if(p < pattern.length() && pattern.charAt(p) == '*'){
                match = s;
                strIdx = p;
                ++p;
            }

            else if(strIdx != -1){
                p = strIdx +1;
                ++match;
                s = match;
            }

            else{
                return false;
            }
        }

        while(p < pattern.length() && pattern.charAt(p) == '*'){
            ++p;
        }

        return p == pattern.length();
    }
    
    public static void main(String[] args) {
		//System.out.println(WildCardMatching.isMatch("leetcode", "*e*t?d*"));
		//System.out.println(WildCardMatching.isMatch("aa", "a"));
        System.out.println(WildCardMatching.isPatternMatch("abbcde", "a*cf"));

	}
}
