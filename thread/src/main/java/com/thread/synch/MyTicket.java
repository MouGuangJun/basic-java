package com.thread.synch;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟卖票导致资源不同步的问题
 */
public class MyTicket extends Thread {
    private int ticket = 10;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket < 0) {
                    System.out.println(Thread.currentThread().getName() + "的票已经全部售完，此时的票数量为：" + ticket);
                    break;
                }
                Thread.sleep(1000); // 延迟1秒，使得ticket可以被其它线程充分改变(可能此时的ticket小于等于0了)

                System.out.println(Thread.currentThread().getName() + " 正在售票,还剩余票数为：" + ticket--);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
