package com.springjiemi.ioc.aop.chapter8_springAopOverView.CGLIB;

/**
 * @author yanwu233
 * @date 2019/4/3 17:06
 */
public class TestPrivateAccessibility {

    private int i = 1;

    class InnerClass{

        public void test(){
            System.out.println(i);
        }
    }

}


