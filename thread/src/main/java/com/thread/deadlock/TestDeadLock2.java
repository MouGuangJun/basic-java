package com.thread.deadlock;

/**
 * 死锁的情况
 */
public class TestDeadLock2 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        // 线程一获得lock1，并试图获取lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("线程一获得了lock1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("线程一获得了lock2");
                }
            }
        });

        // 线程一获得lock2，并试图获取lock1
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("线程二获得了lock2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("线程二获得了lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
