package com.thread.thread;

/**
 * 测试join，让线程强制执行
 */
public class MyJoinThread extends Thread {
    private Thread thread;

    public MyJoinThread(String name, Thread thread) {
        setName(name);
        this.thread = thread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i >= 20 && i < 25) {
                try {
                    System.out.println(thread.getName() + "被迫参与 " + Thread.currentThread().getName() + " 的工作了......" + i);
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 以下语句不管上面判断语句是否执行都会执行的
            System.out.println(Thread.currentThread().getName() + " 正在工作中......" + i);
        }
    }
}
