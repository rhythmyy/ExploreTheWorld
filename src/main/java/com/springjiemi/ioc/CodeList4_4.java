package com.springjiemi.ioc;

import com.springjiemi.ioc.fxsystem.DowJonesNewsListener;
import com.springjiemi.ioc.fxsystem.DowJonesNewsPersister;
import com.springjiemi.ioc.fxsystem.FXNewsProvider;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author yanwu233
 * @date 2019/2/21 14:04
 **/
public class CodeList4_4 {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindVidCode(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();

    }

    public static BeanFactory bindVidCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition newsProvider = new RootBeanDefinition
                (FXNewsProvider.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
        AbstractBeanDefinition newsListener = new RootBeanDefinition
                (DowJonesNewsListener.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition
                (DowJonesNewsPersister.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        registry.registerBeanDefinition("djListener", newsListener);
        registry.registerBeanDefinition("djPersister", newsPersister);

        // 指定依赖关系
        // 1.  可以通过构造方法注入方式
        // ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        // constructorArgumentValues.addIndexedArgumentValue(0, newsListener);
        // constructorArgumentValues.addIndexedArgumentValue(1, newsPersister);
        // newsProvider.setConstructorArgumentValues(constructorArgumentValues);

        // 2. 可以通过set方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        return (BeanFactory) registry;

    }
}
