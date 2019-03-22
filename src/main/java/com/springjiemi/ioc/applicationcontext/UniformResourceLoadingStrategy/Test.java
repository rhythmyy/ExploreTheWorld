package com.springjiemi.ioc.applicationcontext.UniformResourceLoadingStrategy;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import static org.junit.Assert.*;

/**
 * @author yanwu233
 * @date 2019/3/20 16:01
 **/
public class Test {
    public static void main(String[] args) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("D:/spring21site/README");
        assertTrue(resource instanceof ClassPathResource);
        assertFalse(resource.exists());


        Resource resource1 = resourceLoader.getResource("file:D:/spring21site/README");
        System.out.println(resource1);

        Resource resource2 = resourceLoader.getResource("http://www.spring21.cn");
        System.out.println(resource2);

    }

    @org.junit.Test
    public void test(){
        ResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource = fileSystemResourceLoader.getResource("D:/spring21site/README");
        assertTrue(resource instanceof FileSystemResource);
        assertFalse(resource.exists());

        Resource resource1 = fileSystemResourceLoader.getResource("file:D:/spring21site/README");
        assertTrue(resource1 instanceof  UrlResource);
        assertTrue(resource1.exists());


    }


    @org.junit.Test
    public void test1(){
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource("D:/spring21site/README");
        assertTrue(resource instanceof ClassPathResource);
        assertFalse(resource.exists());
    }

    @org.junit.Test
    public void test2(){
        new ClassPathXmlApplicationContext("classpath:beanpostprocessor/spring-bean.xml");
    }
}
