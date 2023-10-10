package com.thread.deadlock;

public class DeadLockDemo {

    //两把锁 LockA 和 LockB
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        //开启两个线程 A B
        //线程A
        new Thread(() -> {
            //线程A获取到LockA锁
            synchronized (lockA) {
                System.out.println("线程A获取到LockA锁");
                try {
                    //睡眠100毫秒，确保B线程获取到LockB锁
                    Thread.sleep(100);
                    //尝试获取lockB，此时lockB在线程B手里没有释放
                    synchronized (lockB) {
                        System.out.println("线程A获取到LockB锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        //线程B
        new Thread(() -> {
            //线程B获取到LockB锁
            synchronized (lockB) {
                System.out.println("线程B获取到LockB锁");
                try {
                    //睡眠100毫秒，确保A线程获取到LockA锁
                    Thread.sleep(100);
                    //尝试获取lockA，此时lockA在线程A手里没有释放
                    synchronized (lockA) {
                        System.out.println("线程B获取到LockA锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}
