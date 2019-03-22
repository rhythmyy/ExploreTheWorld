package com.springjiemi.ioc;

import com.springjiemi.ioc.fxsystem.FXNewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author yanwu233
 * @date 2019/2/26 14:13
 **/
public class CodeList4_8 {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanDefinitionRegistry = new DefaultListableBeanFactory();
        BeanFactory beanFactory = bindViaXmlFile(beanDefinitionRegistry);
        FXNewsProvider djNewsProvider = (FXNewsProvider)beanFactory.getBean("djNewsProvider");
        djNewsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaXmlFile(BeanDefinitionRegistry beanDefinitionRegistry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        reader.loadBeanDefinitions("classpath:news-config.xml");
        return (BeanFactory) beanDefinitionRegistry;
    }
}
