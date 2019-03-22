package com.springjiemi.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yanwu233
 * @date 2019/3/7 17:24
 **/
public class NextDayDateFactory implements FactoryBean<LocalDateTime> {

    @Override
    public LocalDateTime getObject() throws Exception {
        return LocalDateTime.now().plusDays(1);
    }

    @Override
    public Class<?> getObjectType() {
        return LocalDateTime.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
