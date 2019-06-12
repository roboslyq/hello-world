package com.roboslyq.java.java8.stream;

import java.util.Random;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        Stream.generate(()-> {
                    print("开始生产");
                    return new Random().nextInt(10);}
            )
                .limit(10)
                .filter(val -> {
                    boolean rel = val > 3;
                    if(rel){
                        print("开始过滤,元素符合条件，进行下一步操作");
                    }else {
                        print("开始过滤,元素"+ val +"不符合条件，返回重新生产 \n\n");
                    }
                    return rel;
                })
                .forEach(val ->{
                    print("开始最终结果处理 :" +val +"\n\n");
                });
    }

    private static void print(Object obj){
        System.out.println("[ " + Thread.currentThread().getId() + " ]: " + obj );
    }

}
