package com.thread.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Runnable简单实例
 */
public class SimpleRunnablePool {
    public static void main(String[] args) {

        // 1.创建一个线程池,指定线程的数量为4
        ExecutorService pools = Executors.newFixedThreadPool(4);
        // 2.添加线程任务
        Runnable target = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "正在执行任务......" + i);
            }
        };

        pools.submit(target); // 第一次提交任务，此时创建新线程
        pools.submit(target); // 第二次提交任务，此时创建新线程
        pools.submit(target); // 第三次提交任务，此时创建新线程
        pools.submit(target); // 第四次提交任务，此时创建新线程

        pools.submit(target); // 第五次提交任务，复用之前的线程
        pools.shutdown(); // 当所有任务全部完成后才关闭线程池
        // pools.shutdownNow(); // 立即关闭线程池

    }
}
