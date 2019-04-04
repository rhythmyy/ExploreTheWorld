package com.springjiemi.ioc.applicationcontext.UniformResourceLoadingStrategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author yanwu233
 * @date 2019/3/25 13:36
 **/
@Component
public class FooBar implements ApplicationContextAware {
    private ResourceLoader resourceLoader;

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    // @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String toString() {
        return "FooBar{" +
                "resourceLoader=" + resourceLoader +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        resourceLoader = applicationContext;
    }

    public void setBasenames(String... basenames) {
        System.out.println(basenames);

    }


    public void setBoolean(Boolean booleanVal) {
        booleanVal = false;
    }

    public void setInteger(Integer i) {
        i = 1;
    }


    // void testDefaultMethod(){}

}
