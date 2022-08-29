package com.thread.deadlock;

public class FirstCorssBridge {

    public synchronized void tell(SecondCorssBridge scb) {
        System.out.println("张三告诉王五：我先过，你后过,否则你别想过这桥！");
        scb.cross();
    }

    // 以下函数不会执行
    public synchronized void cross() {
        System.out.println("张三快快乐乐地过桥了……");
    }
}
