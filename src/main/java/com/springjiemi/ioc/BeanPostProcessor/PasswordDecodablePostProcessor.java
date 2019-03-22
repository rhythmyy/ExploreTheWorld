package com.springjiemi.ioc.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yanwu233
 * @date 2019/3/19 15:11
 **/
@Component
public class PasswordDecodablePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof PasswordDecodable){
            String encodedPassword = ((PasswordDecodable) bean).getEncodedPassword();
            ((PasswordDecodable) bean).setDecodedPassword(decodePassword(encodedPassword));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private String decodePassword(String password){
        return password + "hahaha";
    }
}
