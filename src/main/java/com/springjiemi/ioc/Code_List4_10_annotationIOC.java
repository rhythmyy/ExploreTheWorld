package com.springjiemi.ioc;

import com.springjiemi.ioc.fxsystem.FXNewsProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanwu233
 * @date 2019/2/26 15:03
 **/
public class Code_List4_10_annotationIOC {
    public static void main(String[] args) {
         ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("classpath:news-config-annotation.xml");
        FXNewsProvider fxNewsProvider = (FXNewsProvider)container.getBean("FXNewsProvider");
        fxNewsProvider.getAndPersistNews();
    }
}
