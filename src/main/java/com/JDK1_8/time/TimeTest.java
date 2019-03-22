package com.JDK1_8.time;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.time.*;

/**
 * @author yanwu233
 * @date 2019/3/4 11:02
 **/
public class TimeTest {
    @Test
    public void test1(){
        // 获取当前的日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate localDate = now.toLocalDate();
        System.out.println("localDate: " + localDate);

        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        int second = now.getSecond();
        int nano = now.getNano();

        System.out.println("月: " + month + ", 日: " + dayOfMonth + ", 秒: " + second + ", 毫秒: " + nano);

        LocalDateTime date2 = now.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);


        // 12 December 2014
        LocalDate.of(1994, Month.NOVEMBER, 21);

        // 22h  15min
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println(date4);

        // LocalTime now = LocalTime.now();
        // System.out.println("当前时间: " + now);

        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    @Test
    public void testZonedDateTime(){
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println(date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId systemDefault = ZoneId.systemDefault();
        System.out.println("当前时区: " + systemDefault);
    }


    @Test
    public void test(){
        System.out.println(null == null);
    }


}
