package com.thread.thread;

/**
 * 继承Thread类来实现多线程
 */
public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.name + "正在工作中......" + i);
        }
    }
}
