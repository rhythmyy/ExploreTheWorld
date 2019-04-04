package com.springjiemi.ioc.aop.chapter8_springAopOverView.DynamicProxy;/**
 * @author yanwu233
 * @date 2019/4/1 18:27
 */

/**
 * @author yanwu233
 * @date 2019/4/1 18:27
 */
public class SubjectImpl implements ISubject {


    @Override
    public void request() {
        System.out.println("request sth~~");
    }
}
