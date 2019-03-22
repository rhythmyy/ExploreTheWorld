package com.springjiemi.ioc.beanwrapper;

import static org.junit.Assert.*;

import com.springjiemi.ioc.fxsystem.FXNewsProvider;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @author yanwu233
 * @date 2019/3/13 15:37
 **/
public class CodeList_4_49 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object provider = Class.forName("com.springjiemi.ioc.fxsystem.FXNewsProvider").newInstance();
        Object listener = Class.forName("com.springjiemi.ioc.fxsystem.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("com.springjiemi.ioc.fxsystem.DowJonesNewsPersister").newInstance();

        BeanWrapper newsProvider = new BeanWrapperImpl(provider);
        newsProvider.setPropertyValue("newsListener", listener);
        newsProvider.setPropertyValue("newsPersister", persister);

        assertTrue(newsProvider.getWrappedInstance() instanceof FXNewsProvider);
        assertSame(newsProvider.getWrappedInstance(), provider);
        assertSame(newsProvider.getPropertyValue("newsListener"), listener);
        assertSame(newsProvider.getPropertyValue("newsPersister"), persister);
    }
}
