package com.thread.runnable;

/**
 * 线程的短暂让步
 */
public class MyYieldThread {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Runnable runnable = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " 正在工作中......" + i);
                if (i == 10) {
                    System.out.println(Thread.currentThread().getName() + " 打算将工作交给 " + mainThread.getName() + "了......");
                    Thread.yield(); // 当前线程让步出去
                    System.out.println(Thread.currentThread().getName() + " 又想自己工作了......");
                }
            }
        };

        new Thread(runnable, "子线程").start();

        for (int i = 0; i < 40; i++) {
            System.out.println(mainThread.getName() + " 正在工作中......" + i);
        }
    }
}
