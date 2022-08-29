package com.thread.synch;

public class TestMyTicket {
    public static void main(String[] args) {
        // 一份资源
        MyTicket myTicket = new MyTicket();

        // 共享同一份资源
        new Thread(myTicket, "售票员A").start();
        new Thread(myTicket, "售票员B").start();
        new Thread(myTicket, "售票员C").start();
    }
}
