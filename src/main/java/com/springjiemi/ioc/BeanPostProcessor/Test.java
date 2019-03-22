package com.springjiemi.ioc.BeanPostProcessor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanwu233
 * @date 2019/3/19 15:15
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beanpostprocessor/spring-bean.xml");
        Object dowJonesNewsListener = applicationContext.getBean("dowJonesNewsListener");
        System.out.println(dowJonesNewsListener);

    }
}
