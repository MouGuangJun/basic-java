package com.thread.runnable;

/**
 * 线程的优先级
 */
public class MyPriorityThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " 正在工作中......" + i);
            }
        };

        Thread thread1 = new Thread(runnable, "线程一");
        Thread thread2 = new Thread(runnable, "线程二");

        // 设置优先级
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
