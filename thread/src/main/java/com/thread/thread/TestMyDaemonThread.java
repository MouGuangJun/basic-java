package com.thread.thread;

public class TestMyDaemonThread {

    public static void main(String[] args) {
        MyDaemonThread thread1 = new MyDaemonThread(4, "用户线程");
        // 守护线程的循环次数远多于用户线程
        MyDaemonThread thread2 = new MyDaemonThread(100, "守护线程");

        // thread2设置为守护线程
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();
    }
}
