package com.thread.deadlock;

import lombok.SneakyThrows;

/**
 * 死锁的情况
 */
public class TestDeadLock {
    @SneakyThrows
    public static void main(String[] args) {
        FirstCorssBridge fcb = new FirstCorssBridge();
        SecondCorssBridge scb = new SecondCorssBridge();

        // 运行到里面时 scb会等待fcb
        Runnable runnable = () -> scb.tell(fcb);

        // 启动线程
        new Thread(runnable).start();
        Thread.sleep(1000);

        // 运行到里面时 fcb会等待scb
        fcb.tell(scb);
    }
}
