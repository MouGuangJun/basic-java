package com.thread.example.baozi;

import lombok.SneakyThrows;

public class BaoZiPu implements Runnable {
    private final BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @SneakyThrows
    @Override
    public void run() {
        int count = 0;
        // 让包子铺一直生产包子
        while (true) {
            synchronized (baoZi) {
                if (baoZi.flag) {
                    // 包子铺有包子，需要等待吃货吃完
                    // wait会释放这个锁，并把这个wait的线程加入到这个锁的等待队列中去
                    // 使用wait必须要定义一个synchronized
                    baoZi.wait();
                } else {
                    // 包子铺没有包子
                    // 被唤醒之后，包子铺开始生产包子，每次生产5个包子
                    for (int i = 0; i < 5; i++) {
                        BaoZi baoZi = new BaoZi();
                        // 为了增加难度,交替生产两种类型的包子
                        if (count % 2 == 0) {
                            // 生产三鲜馅的包子，皮是薄皮
                            baoZi.outSide = "薄皮";
                            baoZi.inSide = "三鲜";
                        } else {
                            // 生产猪肉大葱馅的包子，皮是冰皮
                            baoZi.outSide = "冰皮";
                            baoZi.inSide = "猪肉大葱";
                        }

                        count++;
                        System.out.println(Thread.currentThread().getName() + "正在生产,第"
                                + count + "个 , " + baoZi.inSide + " " + baoZi.outSide + "包子");
                        this.baoZi.baoZis.add(baoZi);
                    }

                    // 生产一批包子需要一个过程: 等待1秒
                    Thread.sleep(10);

                    System.out.println(Thread.currentThread().getName() + "已经生产好了， 有包子可以吃了");
                    System.out.println("-----------------------------------------------");
                    // 唤醒吃货线程，让吃货线程去吃包子
                    baoZi.flag = true;
                    baoZi.notify();
                }
            }
        }
    }
}
