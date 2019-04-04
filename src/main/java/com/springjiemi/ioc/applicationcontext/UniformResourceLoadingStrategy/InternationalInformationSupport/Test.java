package com.springjiemi.ioc.applicationcontext.UniformResourceLoadingStrategy.InternationalInformationSupport;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;
import sun.misc.resources.Messages;

import java.util.Locale;
import static org.junit.Assert.*;

/**
 * @author yanwu233
 * @date 2019/3/26 14:02
 **/
public class Test {
    public static void main(String[] args) {
        StaticMessageSource staticMessageSource = new StaticMessageSource();
        staticMessageSource.addMessage("menu.file", Locale.US, "File");
        staticMessageSource.addMessage("menu.edit", Locale.US, "Edit");
        System.out.println(staticMessageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));
        assertEquals("File(F)", staticMessageSource.getMessage("menu.file", new Object[]{"F"}, Locale.US));

        new ResourceBundleMessageSource();
    }
}
