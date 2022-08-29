package com.thread.thread;

/**
 * 设置标识，当线程检测到需要中断时，会执行线程中断的操作
 */
public class MyInterruptThread extends Thread {
    private String name;

    public MyInterruptThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 正在努力工作中......" + i++);
            try {
                System.out.println(Thread.currentThread().getName() + " 准备休息2秒钟了......");
                Thread.sleep(2000);  // 休眠5秒钟
                System.out.println(Thread.currentThread().getName() + " 已经休息2秒钟了......");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被打扰了，不想工作了......");
                break;
            }
        }
    }
}
