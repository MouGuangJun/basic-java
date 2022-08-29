package com.thread.thread;

public class TestMyJoinThread {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        MyJoinThread myJoinThread = new MyJoinThread("子线程", mainThread);
        myJoinThread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); // 每次main线程休眠1秒
                System.out.println(Thread.currentThread().getName() + "正在工作中......" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("我main线程已经完成了所有任务，从此无法再复生了......");
    }
}
