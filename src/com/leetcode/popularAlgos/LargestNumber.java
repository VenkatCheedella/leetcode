package com.leetcode.popularAlgos;

public class LargestNumber {

    static String max = "";

    public static String generateLargestNumber(String input , int k){
        StringBuilder builder = new StringBuilder();
        return helper(0, input.length()-k, builder, input, k);
    }

    private static String helper(int start, int end, StringBuilder builder, String input, int count){
        if(count == 0) return builder.toString() + input.substring(start , end);

        for(int i = start; i <= end; i++){
            StringBuilder oldCopy = new StringBuilder(builder);
            builder.append(input.substring(start, i));
            String currMax = helper(i+1, Math.min(end+1, input.length()), builder, input, --count);
            max = (max.compareTo(currMax) > 0) ? max : currMax;
            builder = oldCopy;
            ++count;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(LargestNumber.generateLargestNumber("432111", 3));
        String s1 = "431";
        String s2= "432";
    }
}
