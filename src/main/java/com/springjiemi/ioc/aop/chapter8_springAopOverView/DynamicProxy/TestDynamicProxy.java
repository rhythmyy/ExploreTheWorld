package com.springjiemi.ioc.aop.chapter8_springAopOverView.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author yanwu233
 * @date 2019/4/1 18:39
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        ISubject subject = (ISubject)Proxy.newProxyInstance(ISubject.class.getClassLoader(),
                new Class[]{ISubject.class},
                new RequestCtrlInvocationHandler(new SubjectImpl()));
        System.out.println(subject instanceof Proxy);
        subject.request();
        // System.out.println(subject.equals("a"));

        IRequestable requestable = (IRequestable)Proxy.newProxyInstance(TestDynamicProxy.class.getClassLoader(),
                new Class[]{IRequestable.class},
                new RequestCtrlInvocationHandler(new RequestableImpl()));
        requestable.request();

    }
}
