package com.thread.runnable;

/**
 * 线程进入休眠状态
 */
public class MySleepThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 50; i++) {
                System.out.println(threadName + " 正在工作中......" + i);
                if (i == 20) {
                    try {
                        System.out.println(threadName + " 等一会儿就要休息三秒钟了......");
                        Thread.sleep(3000); // 当前线程休眠五秒钟
                        System.out.println(threadName + " 已经休息三秒钟了......");
                    } catch (InterruptedException e) {
                        System.out.println(threadName + " 休眠被打扰了......");
                    }
                }
            }
        };

        new Thread(runnable, "sleep thread").start();
    }
}
