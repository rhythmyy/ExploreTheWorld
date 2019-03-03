package com.JDK1_8.defaultMethod;

/**
 * @author yanwu233
 * @date 2019/3/1 11:45
 **/
public interface FourWheelVehicle {

    default void print(){
        System.out.println("我是一辆四轮车");
    }
}
