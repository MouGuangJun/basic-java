package com.thread.runnable;

/**
 * 实现Runnable接口
 */
public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.name + "正在工作中......" + i);
        }
    }
}
