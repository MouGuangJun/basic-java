package com.thread.example.baozi;

import java.util.ArrayList;
import java.util.List;

public class BaoZi {
    String outSide; // 皮
    String inSide;  // 馅
    final List<BaoZi> baoZis = new ArrayList<>();
    boolean flag;


    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        Thread baoZiPu = new Thread(new BaoZiPu(baoZi), "包子铺");
        Thread chiHuo1 = new Thread(new ChiHuo(baoZi), "吃货1");
        Thread chiHuo2 = new Thread(new ChiHuo(baoZi), "吃货2");

        baoZiPu.start();
        chiHuo1.start();
        chiHuo2.start();
    }
}
