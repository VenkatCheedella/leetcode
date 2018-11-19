package com.leetcode.popularAlgos;

public class Sample {
    public static void main(String[] args){
        Thread newThread = new Thread(new SampleThread());
        newThread.start();

        for(int i=0; i< 10; i++){
            Thread newThread1 = new Thread(new SampleThread());
            newThread1.start();
        }

    }


}
