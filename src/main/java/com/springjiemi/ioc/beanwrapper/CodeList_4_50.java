package com.springjiemi.ioc.beanwrapper;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;
/**
 * @author yanwu233
 * @date 2019/3/13 17:40
 **/
public class CodeList_4_50 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Object provider = Class.forName("com.springjiemi.ioc.fxsystem.FXNewsProvider").newInstance();
        Object listener = Class.forName("com.springjiemi.ioc.fxsystem.DowJonesNewsListener").newInstance();
        Object persister = Class.forName("com.springjiemi.ioc.fxsystem.DowJonesNewsPersister").newInstance();

        Class providerClazz = provider.getClass();
        Field newsListenerField = providerClazz.getField("newsListener");
        newsListenerField.set(provider, listener);
        Field newsPersisterField = providerClazz.getField("newsPersister");
        newsPersisterField.set(provider, persister);

        assertSame(newsListenerField.get(provider), listener);
        assertSame(newsPersisterField.get(provider), persister);


    }

    @Test
    public void test(){
        // HashMap<String, Object> map = new HashMap<>();
        String str = "{'Action' : 'DescribeInstances','InstanceIds.0' : 'ins-09dx96dg','Limit' : 20,'Nonce' : 11886,'Offset' : 0,'Region' : 'ap-guangzhou','SecretId' : 'AKIDz8krbsJ5yKBZQpn74WFkmLPx3EXAMPLE','Timestamp' : 1465185768, 'Version': '2017-03-12'}";
        Map map = JSON.parseObject(str, Map.class);
        TreeMap<Object, Object> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);



    }


}
