package com.springjiemi.ioc;


import com.springjiemi.ioc.fxsystem.FXNewsProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    }
}
