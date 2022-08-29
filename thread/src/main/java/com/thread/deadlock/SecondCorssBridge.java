package com.thread.deadlock;

public class SecondCorssBridge {

    public synchronized void tell(FirstCorssBridge fcb) {
        System.out.println("王五告诉张三：我先过，你后过,否则你别想过这桥！");
        fcb.cross();
    }

    // 以下函数不会执行
    public synchronized void cross() {
        System.out.println("王五快快乐乐地过桥了……");
    }
}
