package com.thread.callable;

import lombok.SneakyThrows;

import java.util.concurrent.FutureTask;

public class TestMyCallable {
    @SneakyThrows
    public static void main(String[] args) {
        // FutureTask类接收继承Callable接口的MyCallable的实例
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new MyCallable("线程一"));
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new MyCallable("线程二"));
        FutureTask<Integer> futureTask3 = new FutureTask<Integer>(new MyCallable("线程三"));

        // 启动多线程
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();

        // 获取线程执行的结果
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
    }
}
