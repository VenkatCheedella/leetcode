package com.leetcode.practiseField;

public class VarArgs {

    public static void sample(String... args){
        if(args == null){
            System.out.println("Null check works");
        }
        if(args.length == 0){
            System.out.println("Lenght check works");
        }
        else{
            System.out.println(args[0]);
        }
    }

    public static void main(String[] args) {

        VarArgs.sample();
    }
}
