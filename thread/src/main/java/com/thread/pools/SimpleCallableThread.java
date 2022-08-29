package com.thread.pools;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * Runnable简单实例
 */
public class SimpleCallableThread {

    public static void main(String[] args) {
            // 加法计算
            Operator sumOperator = times -> {
                long sum = 0;
                for (int i = 0; i < times; i++) {
                    sum += i;
                }

                return sum;
            };

            thread(sumOperator);// 多线程的方式

            single(sumOperator);// 单线程的方式
    }

    // 多线程的方式
    @SneakyThrows
    private static void thread(Operator sumOperator) {
        ExecutorService pools = Executors.newFixedThreadPool(4);
        long start = System.currentTimeMillis();
        // 提交求出1-100000和的线程任务
        Future<String> t1 = pools.submit(new MyCallable(sumOperator, 100000));
        Future<String> t2 = pools.submit(new MyCallable(sumOperator, 200000));
        Future<String> t3 = pools.submit(new MyCallable(sumOperator, 300000));
        Future<String> t4 = pools.submit(new MyCallable(sumOperator, 400000));
        Future<String> t5 = pools.submit(new MyCallable(sumOperator, 500000));

        System.out.println(t1.get());
        System.out.println(t2.get());
        System.out.println(t3.get());
        System.out.println(t4.get());
        System.out.println(t5.get());

        long end = System.currentTimeMillis();
        pools.shutdown();
        System.out.println("采用多线程所耗时间为：" + (end - start) * 1.0 / 1000 + "s");
    }

    static class MyCallable implements Callable<String> {
        private Operator operator;
        private int times;

        public MyCallable(Operator operator, int times) {
            this.operator = operator;
            this.times = times;
        }

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName() + "任务执行的最终结果为：" + operator.sum(times);
        }
    }

    // 单线程的方式
    private static void single(Operator operator) {
        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "任务执行的最终结果为：" + operator.sum(100000));
        System.out.println(Thread.currentThread().getName() + "任务执行的最终结果为：" + operator.sum(200000));
        System.out.println(Thread.currentThread().getName() + "任务执行的最终结果为：" + operator.sum(300000));
        System.out.println(Thread.currentThread().getName() + "任务执行的最终结果为：" + operator.sum(400000));
        System.out.println(Thread.currentThread().getName() + "任务执行的最终结果为：" + operator.sum(500000));

        long end = System.currentTimeMillis();
        System.out.println("采用单线程所耗时间为：" + (end - start) * 1.0 / 1000 + "s");
    }

    // 逻辑运算符
    interface Operator {
        long sum(int times);
    }
}
