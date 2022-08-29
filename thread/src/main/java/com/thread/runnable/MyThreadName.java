package com.thread.runnable;

/**
 * 线程的名称
 */
public class MyThreadName {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        new Thread(runnable, "线程一").start();
        new Thread(runnable, "线程二").start();
        new Thread(runnable).start();// 使用默认的线程名称
    }
}
