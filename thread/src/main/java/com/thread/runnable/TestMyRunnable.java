package com.thread.runnable;

public class TestMyRunnable {
    public static void main(String[] args) {
        // 实例化线程对象
        Thread thread1 = new Thread(new MyRunnable("线程一"));
        Thread thread2 = new Thread(new MyRunnable("线程二"));
        Thread thread3 = new Thread(new MyRunnable("线程三"));

        // 启动实例线程对象
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
