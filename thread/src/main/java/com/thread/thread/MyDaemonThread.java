package com.thread.thread;

/**
 * 守护线程
 */
public class MyDaemonThread extends Thread {
    private int times;

    public MyDaemonThread(int times, String name) {
        this.times = times;
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            if (Thread.currentThread().isDaemon()) {
                try {
                    Thread.sleep(10); // 如果是守护线程，则休眠0.01秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " 正在工作中......" + i);
        }
    }
}
