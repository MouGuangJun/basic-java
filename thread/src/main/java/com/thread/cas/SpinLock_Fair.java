package com.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 公平自旋锁
 *
 * @author CaveWang
 * @date 2022/10/5 11:50
 */
public class SpinLock_Fair {
    /**
     * 当前持有锁的号码
     */
    private final AtomicInteger serviceNum = new AtomicInteger(0);
    /**
     * 记录锁重入次数
     */
    private final AtomicInteger count = new AtomicInteger(0);
    /**
     * 排队号码
     */
    private final AtomicInteger ticketNum = new AtomicInteger(0);

    /**
     * 各线程存放自己所申请的排队号码
     */
    private static final ThreadLocal<Integer> threadLocalNum = new ThreadLocal<>();

    public void lock() {
        Integer num = threadLocalNum.get();
        if (num != null && num == serviceNum.get()) {
            // 当前线程已经持有锁, 则记录重入次数即可
            count.incrementAndGet();
            return;
        }

        // 申请一个排队号码
        num = requestTicketNum();
        threadLocalNum.set(num);
        // 自旋等待, 直到该排队号码与serviceNum相等
        while (num != this.serviceNum.get()) ;
    }

    public void unlock() {
        Integer num = threadLocalNum.get();
        if (num != null && num == serviceNum.get()) {
            if (count.get() > 0) {
                // 锁重入, 直接自减即可
                count.decrementAndGet();
            } else {
                threadLocalNum.remove();
                // 自增serviceNum, 以便下一个排队号码的线程能够退出自旋
                serviceNum.set(num + 1);
            }
        }
    }

    /**
     * 申请一个排队号码
     */
    private int requestTicketNum() {
        return ticketNum.getAndIncrement();
    }

    public static void main(String[] args) {
        SpinLock_Fair spinLock = new SpinLock_Fair();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了了自旋锁");
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
