package com.springjiemi.ioc;


import com.springjiemi.ioc.fxsystem.FXNewsProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author yanwu233
 * @date 2019/3/7 14:50
 **/
public class Test {

    @org.junit.Test
    public void testAutowireConstructor(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:news-config.xml");
        FXNewsProvider djNewsProvider = (FXNewsProvider)classPathXmlApplicationContext.getBean("djNewsProvider");
        djNewsProvider.getAndPersistNews();
        throw new AbstractMethodError();
    }

    @org.junit.Test
    public void test(){
        System.out.println(LocalDateTime.of(2099, 12, 31, 23, 59, 59)
               .toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(new Date(4102415999L));
        Date date = new Date(LocalDateTime.of(2099, 12, 31, 23, 59, 59)
                .toEpochSecond(ZoneOffset.of("+8")) * 1000);
        System.out.println(date);

        System.out.println(LocalDateTime.of(1970, 1, 1, 0, 0, 0)
                .toEpochSecond(ZoneOffset.of("+0")));
    }
}
