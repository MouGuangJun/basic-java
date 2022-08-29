package com.thread.thread;

import lombok.SneakyThrows;

public class TestMyInterruptThread {
    @SneakyThrows
    public static void main(String[] args) {
        MyInterruptThread mt1 = new MyInterruptThread("线程一");// 线程一就绪
        MyInterruptThread mt2 = new MyInterruptThread("线程二");// 线程二就绪
        MyInterruptThread mt3 = new MyInterruptThread("线程三");// 线程三就绪

        // 启动线程
        mt1.start();
        mt2.start();
        mt3.start();

        // 以下通过利用main线程控制 线程一 中断
        Thread.sleep(6000); // 使main方法先休眠6秒钟，即让子线程先运行6秒钟
        if (!mt1.isInterrupted()) {
            System.out.println("吵闹~~~");
            mt1.interrupt();// 中断线程一的执行
        }
    }
}
