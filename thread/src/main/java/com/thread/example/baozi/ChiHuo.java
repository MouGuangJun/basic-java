package com.thread.example.baozi;

import lombok.SneakyThrows;

public class ChiHuo implements Runnable {
    private final BaoZi baoZi;

    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (!baoZi.flag) {// 没有包子，吃货进入等待状态
                    baoZi.wait();
                } else {
                    // 被唤醒后执行吃包子，每次都从第一个开始吃
                    BaoZi baoZi = this.baoZi.baoZis.get(0);
                    System.out.println(Thread.currentThread().getName() + "正在吃:" + baoZi.outSide + baoZi.inSide + "包子");
                    // 吃完包子
                    this.baoZi.baoZis.remove(0);

                    // 包子被吃货吃完了
                    if (this.baoZi.baoZis.size() == 0) {
                        this.baoZi.flag = false;
                    }

                    // 通知包子铺，需要生产包子了
                    // 防止出现死锁的情况，每次都要叫醒线程
                    this.baoZi.notify();
                }
            }
        }
    }
}
