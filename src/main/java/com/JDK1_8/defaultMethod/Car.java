package com.JDK1_8.defaultMethod;

import org.jetbrains.annotations.Contract;

/**
 * @author yanwu233
 * @date 2019/3/1 11:46
 **/
public class Car implements Vehicle, FourWheelVehicle {

    @Override
    public void print() {
        Vehicle.super.print();
        FourWheelVehicle.super.print();
        Vehicle.soundHorn();
        System.out.println("this is a car");
    }

    @Contract
    public static void main(String[] args) {
        // 静态方法中不能使用 Vehicle.super, 这样是调用父接口的实例方法.
        // Vehicle.
        new Car().print();
    }
}
