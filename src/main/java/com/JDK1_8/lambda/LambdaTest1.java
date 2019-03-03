package com.JDK1_8.lambda;

/**
 * @author yanwu233
 * @date 2019/3/1 10:35
 **/
public class LambdaTest1 {
    // public static void main(String[] args) {
    //     final int num = 1;
    //     Converter<Integer, String> converter = (param) -> System.out.println(String.valueOf(param + num));
    //     converter.convert(10);
    // }

    public interface Converter<T1, T2>{
        void convert(int i);
    }

    // public static void main(String[] args) {
    //     int num = 1;
    //     Converter<Integer, String> converter = (param) -> System.out.println(String.valueOf(param + num));
    //     converter.convert(10);
    //     num = 10;
    // }

    // public static void main(String[] args) {
    //     String first = "";
    //     Converter<Integer, String> converter = (first, second)
    // }
}
