package com.roboslyq.core.thread;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        //(10)获取一个随机数生成器
        ThreadLocalRandom random =  ThreadLocalRandom.current();

        //(11)输出10个在0-5（包含0，不包含5）之间的随机数
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(5));
        }

//        int test =  ThreadLocalRandom.getProbe();
////            ThreadLocalRandom.localInit();
////            r = ThreadLocalRandom.getProbe();
////        }
    }
}
