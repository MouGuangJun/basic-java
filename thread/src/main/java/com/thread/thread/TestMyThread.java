package com.thread.thread;

public class TestMyThread {
    public static void main(String[] args) {
        // 实例化线程对象
        MyThread myThread1 = new MyThread("线程一");
        MyThread myThread2 = new MyThread("线程二");
        MyThread myThread3 = new MyThread("线程三");

        // 启动实例线程对象
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
