package com.JDK1_8.lambda;

/**
 * @author yanwu233
 * @date 2019/2/28 16:24
 **/
public class LambdaTest {

    static String salution = "hello";
    public static void main(String[] args) {
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不使用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b;};

        MathOperation division = (a, b) -> a / b;

        System.out.println("addition.operation(10, 5): " + addition.operation(10, 5));
        System.out.println("subtraction.operation(10, 5): " + subtraction.operation(10, 5));
        System.out.println("multiplication.operation(10, 5): " + multiplication.operation(10, 5));
        System.out.println("division.operation(10, 5): " + division.operation(10, 5));

        GreetingService greetingService = message -> System.out.println(salution + message);
        greetingService.sayMessage("wuwu");


    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
