package com.JDK1_8.defaultMethod;

/**
 * @author yanwu233
 * @date 2019/3/1 11:43
 **/
public interface Vehicle {
    default void print(){
        System.out.println("我是一辆车");
    }

    static void soundHorn(){
        System.out.println("按喇叭");
    }
}
