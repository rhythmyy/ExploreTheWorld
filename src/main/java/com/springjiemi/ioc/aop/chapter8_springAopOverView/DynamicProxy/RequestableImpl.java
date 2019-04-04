package com.springjiemi.ioc.aop.chapter8_springAopOverView.DynamicProxy;/**

/**
 * @author yanwu233
 * @date 2019/4/1 18:33
 */
public class RequestableImpl implements IRequestable {
    @Override
    public void request() {
        System.out.println("requestableImpl");
    }
}
