package com.springjiemi.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @author yanwu233
 * @date 2019/3/7 17:30
 **/
public class NextDayDateDisplayer {
    private LocalDateTime dateOfNextDay;

    public LocalDateTime getDateOfNextDay() {
        return dateOfNextDay;
    }

    public void setDateOfNextDay(LocalDateTime dateOfNextDay) {
        this.dateOfNextDay = dateOfNextDay;
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("classpath:factorybean/spring.xml");
        Object nextDayDate = container.getBean("nextDayDate");
        assertTrue(nextDayDate instanceof LocalDateTime);

        Object factoryBean = container.getBean("&nextDayDate");
        assertTrue(factoryBean instanceof NextDayDateFactory);

        Object factoryGetObject = ((FactoryBean) factoryBean).getObject();
        assertTrue(factoryGetObject instanceof LocalDateTime);

        assertNotSame(nextDayDate, factoryGetObject);
        assertEquals(((LocalDateTime)nextDayDate).getDayOfYear(), ((LocalDateTime)factoryGetObject).getDayOfYear());

    }
}
