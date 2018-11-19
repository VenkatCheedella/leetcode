package com.leetcode.practiseField;

public class BillSingleton {


    public BillSingleton(){

    }

    private static class CreateSingleton{
        private static final BillSingleton billSingleton = new BillSingleton();

    }
    public static BillSingleton getInstance(){
        return CreateSingleton.billSingleton;
    }
}
