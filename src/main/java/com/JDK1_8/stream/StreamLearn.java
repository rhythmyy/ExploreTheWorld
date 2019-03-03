package com.JDK1_8.stream;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author yanwu233
 * @date 2019/2/28 15:23
 **/
public class StreamLearn {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jdk");
        List<String> filterd = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filterd);
    }

    @Test
    public void test(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void test1(){
        List<Integer> integers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squareNumberList = integers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squareNumberList);
    }

    @Test
    public void test2(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jdk");
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println(count);
    }

    @Test
    public void test3(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void test4(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    @Test
    public void test5(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jdk");
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println(count);
    }

    @Test
    public void test6(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        String collect = strings.stream().filter(StringUtils::isNotEmpty).collect(Collectors.joining(", "));
        System.out.println(collect);
    }

    @Test
    public void test7(){
        List<Integer> integers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数: " + statistics.getMax());
        System.out.println("列表中最小的数: " + statistics.getMin());
        System.out.println("所有数之和: " + statistics.getSum());
        System.out.println("平均数: " + statistics.getAverage());
    }
}
