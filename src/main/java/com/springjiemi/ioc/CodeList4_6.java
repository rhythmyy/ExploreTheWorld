package com.springjiemi.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * @author yanwu233
 * @date 2019/2/25 17:08
 **/
public class CodeList4_6 {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegitry = new DefaultListableBeanFactory();
        BeanFactory container = buildViaPropertiesFile(beanRegitry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
        // ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        // System.out.println(contextClassLoader.getResource(""));
    }

    public static BeanFactory buildViaPropertiesFile(BeanDefinitionRegistry registry) {
        PropertiesBeanDefinitionReader reader =
                new PropertiesBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:binding-config.properties");
        return (BeanFactory) registry;

    }

}
