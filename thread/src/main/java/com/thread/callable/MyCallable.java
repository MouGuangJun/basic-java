package com.thread.callable;

import java.util.concurrent.Callable;

/**
 * 带返回值和可以抛出异常的多线程接口Callable
 */
public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i < 50; i++) {
            sum += i;
            System.out.println(this.name + "正在工作中......" + i);
        }

        return sum;
    }
}
