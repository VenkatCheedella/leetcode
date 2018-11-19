package com.leetcode.popularAlgos;

import java.util.*;

public class InheritanceExample {

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new ManualStick();
        Car c3 = new AutomaticCar();
        ManualStick c4 = new ManualStick();
        AutomaticCar c5 = new AutomaticCar();

        //Question 1 -> What is the difference between c2 and c4 objects?
        c2.paintCar();  // What is the output?
        System.out.println(c2.countOfWheels()); // What is the output?
        System.out.println(c4.countOfWheels());
        System.out.println("Automatic car status : " + c5.autoLaneSwitchEnbaled());

        System.out.println("-------------------------");
        c1.paintCar();
        c2.paintCar();
        c3.paintCar();

        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.peek();

        Stack<Integer> nums = new Stack<>();

    }
}

class Car {
    public void paintCar(){
        System.out.println("Paint red for doors");
    }

    public int countOfWheels(){
        return 4;
    }
}


class ManualStick extends Car{

    @Override
    public void paintCar(){
        System.out.println("Paint car in blue");
    }
}

class AutomaticCar extends Car{

    boolean autoLaneSwitch = true;

    @Override
    public void paintCar(){
        System.out.println("Paint car in green");
    }

    public boolean autoLaneSwitchEnbaled(){
        return autoLaneSwitch;
    }
}


