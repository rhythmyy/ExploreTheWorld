package com.springjiemi.ioc.aop.chapter8_springAopOverView.DynamicProxy;/**
 * @author yanwu233
 * @date 2019/4/1 18:13
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalTime;

/**
 * @author yanwu233
 * @date 2019/4/1 18:13
 */
public class RequestCtrlInvocationHandler implements InvocationHandler {
    private static final Log logger = LogFactory.getLog(RequestCtrlInvocationHandler.class);

    private Object target;

    public RequestCtrlInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("request".equals(method.getName())){
            LocalTime startTime = LocalTime.of(0, 0);
            LocalTime endeTime = LocalTime.of(6, 0);
            LocalTime now = LocalTime.now();
            if(now.isBefore(endeTime) && now.isAfter(startTime)){
                logger.warn("service is not available now");
            }

            return method.invoke(target, args);
        }
        return null;
    }
}
