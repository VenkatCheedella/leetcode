package com.leetcode.popularAlgos;


public class StrWithout3a3b {
	public static String strWithout3a3b(int A, int B) {
        int i = 0;
        int j = 0;
        char start = 'a', end = 'b';
        int largeCount = A, smallCount =B;
        if(A<B){
            char plcHolder = start;
            start = end;
            end = plcHolder;
            largeCount = B;
            smallCount = A;
        }
        
        StringBuilder builder = new StringBuilder();
        for(i=largeCount,j =smallCount; i>0 && j>0;){
            builder.append(start);
            if(--i <= 0) break;
            builder.append(start);
            i--;
            builder.append(end);
            if(--j <= 0) break;
            builder.append(end);
            j--;
        }
        String result = builder.toString();
        int idx = 1;
        while(i > 0 && idx < result.length()) {
        	if(result.charAt(idx) != start && result.charAt(idx-1) != start) {
        		result = result.substring(0, idx) + start + result.substring(idx, result.length());
        		idx = idx+2;
        		i--;
        	}
        	else ++idx;
        }
        int endPrefix = 2;
        //add largestsize char string at end
        if(start != result.charAt(result.length()-1)) {
        	while(i >0 && endPrefix > 0){
                result = result + start;
                i--;
                endPrefix--;
            }
        }  
//        check for smaller char at prefix
        int startPrefix = 2;
        while(j > 0 && startPrefix > 0){
            result = end + result;
            j--;
            startPrefix--;
        }
        while(j > 0 && idx < result.length()) {
        	if(result.charAt(idx) != start && result.charAt(idx-1) != start) {
        		result = result.substring(0, idx) + start + result.substring(idx, result.length());
        		idx = idx+2;
        		j--;
        	}
        	else ++idx;
        }
//        endPrefix = 2;
//        //check for smaller char at suffix
//        if(end != tempString.charAt(tempString.length()-1)){
//            while(j >0 && endPrefix > 0){
//                tempString = tempString + end;
//                j--;
//                endPrefix--;
//            }
//        }
//        if(end == tempString.charAt(tempString.length()-1) && 
//        		start == tempString.charAt(tempString.length()-2) && j > 0) {
//        		tempString = tempString + end;
//        }
//        if(tempString.length() != A+B) {
//        	System.out.println("Length of the string :" + tempString.length());
//        	int countA = 0;
//        	int countB = 0;
//        	for(char c : tempString.toCharArray()) {
//        		if(c == 'a') ++countA;
//        		else ++countB;
//        	}
//        	System.out.println("Count A  " + countA + " Count of B" + countB);
//        	System.out.println("Soemthing went wrong in logic");
//        }
        return result;
    }
	
	public static void main(String[] args) {
//		int a = 1, b =2;
//		int a = 8, b =4;
//		int a = 8, b =7;
//		int a = 27, b =33;
//		int a = 4, b =1;
		int a = 2, b =3;
		System.out.println(StrWithout3a3b.strWithout3a3b(a, b));
	}
}
