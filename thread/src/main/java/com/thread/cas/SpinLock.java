package com.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 非公平自旋锁
 *
 * @author CaveWang
 * @date 2022/10/5 11:10
 */
public class SpinLock {
    /**
     * 锁的持有者
     */
    private final AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * 记录锁重入次数
     */
    private final AtomicInteger count = new AtomicInteger(0);


    public void lock() {
        Thread current = Thread.currentThread();
        // 当前线程已经持有锁, 则记录重入次数即可
        if (current == owner.get()) {
            count.incrementAndGet();
            return;
        }

        while (!owner.compareAndSet(null, current)) ;
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (count.get() > 0) {
                // 锁重入, 直接自减即可
                count.decrementAndGet();
            } else {
                owner.set(null);
            }
        }
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
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
        t1.start();
        t2.start();
    }
}

