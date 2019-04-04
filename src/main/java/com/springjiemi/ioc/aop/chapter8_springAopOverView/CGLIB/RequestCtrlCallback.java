package com.springjiemi.ioc.aop.chapter8_springAopOverView.CGLIB;


import com.springjiemi.ioc.aop.chapter8_springAopOverView.DynamicProxy.IRequestable;
import com.springjiemi.ioc.aop.chapter8_springAopOverView.DynamicProxy.RequestableImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.Objects;

/**
 * @author yanwu233
 * @date 2019/4/2 15:36
 */
public class RequestCtrlCallback implements MethodInterceptor {
    private static final Log logger = LogFactory.getLog(RequestCtrlCallback.class);



    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if("request".equals(method.getName())){
            LocalTime startTime = LocalTime.of(0, 0);
            LocalTime endeTime = LocalTime.of(6, 0);
            LocalTime now = LocalTime.now();
            if(now.isBefore(endeTime) && now.isAfter(startTime)){
                logger.warn("service is not available now");
                return null;
            }

            return methodProxy.invokeSuper(o, args);
        }
        return null;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallback());

        Requestable o = (Requestable) enhancer.create();
        o.request();
    }
}
