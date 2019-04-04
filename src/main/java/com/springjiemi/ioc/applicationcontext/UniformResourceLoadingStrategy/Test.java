package com.springjiemi.ioc.applicationcontext.UniformResourceLoadingStrategy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sound.midi.Soundbank;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public void test() {
        ResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource = fileSystemResourceLoader.getResource("D:/spring21site/README");
        assertTrue(resource instanceof FileSystemResource);
        assertFalse(resource.exists());

        Resource resource1 = fileSystemResourceLoader.getResource("file:D:/spring21site/README");
        assertTrue(resource1 instanceof UrlResource);
        assertTrue(resource1.exists());


    }


    @org.junit.Test
    public void test1() {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource("D:/spring21site/README");
        assertTrue(resource instanceof ClassPathResource);
        assertFalse(resource.exists());
    }

    @org.junit.Test
    public void test2() {
        ResourceLoader resourceLoader = new ClassPathXmlApplicationContext("classpath:beanpostprocessor/spring-bean.xml");
        Resource resource = resourceLoader.getResource("D:/spring21site/README");
        assertTrue(resource instanceof ClassPathResource);
        Resource resource1 = resourceLoader.getResource("http://www.spring21.cn");
        assertTrue(resource1 instanceof UrlResource);


    }

    @org.junit.Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationcontext.UniformResourceLoadingStrategy/spring.xml");
        String fileMenuName = applicationContext.getMessage("menu.file", new Object[]{"F"}, Locale.US);
        System.out.println(fileMenuName);
        // String fileMenuNameCHINA = applicationContext.getMessage("menu.file", new Object[]{"233", new Date()}, Locale.CHINA);
        // System.out.println(fileMenuNameCHINA);
        // applicationContext.getMessage("menu.edit", null, )
        // FooBar fooBar = (FooBar)applicationContext.getBean("fooBar");
        // List<String> basenames =  new ArrayList<>();

        // fooBar.setBasenames(basenames);

        // System.out.println(fooBar);
        // Object xMailer = applicationContext.getBean("xMailer");
        // System.out.println(xMailer);
    }

    @org.junit.Test
    public void test4() throws IOException {
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource = fileSystemResourceLoader.getResource("/readingPLAN");
        File file = resource.getFile();
        System.out.println(file.getPath());
        System.out.println(file);
        resource.toString();
        System.out.println(resource);
        System.out.println(1);
    }

    @org.junit.Test
    public void testBoolean(){
        Boolean b = true;
        FooBar fooBar = new FooBar();
        fooBar.setBoolean(b);

        Integer i = 0;
        fooBar.setInteger(1);

    }
}
