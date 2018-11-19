package com.leetcode.popularAlgos;

public class SampleThread implements Runnable{

    @Override
    public void run(){
        System.out.println("The name of the thread: " + Thread.currentThread());
    }

}
