package com.leetcode.practiseField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyPractise {

    AtomicBoolean stopExecution = new AtomicBoolean(false);
    AtomicInteger CPU = new AtomicInteger(0);


    class StopExecution implements Runnable{
        public void run(){
            try{
                while(CPU.get() > 65){
                    stopExecution.set(true);
                    Thread.sleep(10000);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public int getCPUOnMediaService(){
        return 10;
    }

    class CPUCheck implements Runnable {

        public void run(){
            try{
                while(!stopExecution.get()){
                    int currentCPU = getCPUOnMediaService();
                    if(CPU.get() < currentCPU) CPU.set(currentCPU);
                    Thread.sleep(5000);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }


    public void startDiagnostics(){
        Thread CPUCheck = new Thread(() -> {
            try{
                while(stopExecution.get()){
                    int currentCPU = new ConcurrencyPractise().getCPUOnMediaService();
                    if(CPU.get() < currentCPU) CPU.set(currentCPU);
                    Thread.sleep(5000);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        });


        Thread StopExecution = new Thread(() -> {
            try{
                while(CPU.get() > 65){
                    stopExecution.set(true);
                    Thread.sleep(50000);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        });

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(CPUCheck);
        service.submit(StopExecution);
    }

    public static void main(String[] args) {




    }

}



