package com.roboslyq.jdk.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取Unsafe操作类
 * 注：Unsafe各种方法的offset与JVM对象在内存中的布局相关。
 * sun.misc.Unsafe是JDK内部用的工具类。它通过暴露一些Java意义上说“不安全”的功能给Java层代码，来让JDK能够更多的使用Java代码来
 * 实现一些原本是平台相关的、需要使用native语言（例如C或C++）才可以实现的功能。该类不应该在JDK核心类库之外使用。
 * <p>
 * JVM的实现可以自由选择如何实现Java对象的“布局”，也就是在内存里Java对象的各个部分放在哪里，包括对象的实例字段和一些元数据之类。
 * sun.misc.Unsafe里关于对象字段访问的方法把对象布局抽象出来，它提供了objectFieldOffset()方法用于获取某个字段相对Java对象的“起始地址”的偏移量，
 * 也提供了getInt、getLong、getObject之类的方法可以使用前面获取的偏移量来访问某个Java对象的某个字段。
 * <p>
 * 每个JVM都有自己的方式来实现Java对象的布局。
 * Oracle/Sun HotSpot VM所使用的Java对象布局可以参考这篇博客：http://www.codeinstructions.com/2008/12/java-objects-memory-structure.html
 * （这篇内容其实并不是太完整但只是入门凑合看看是够了。另外它只针对32位的JDK6的HotSpot VM的默认配置。）
 * <p>
 * 同事Aleksey Shipilev专门写了个小工具来显示Java对象的布局：
 * https://github.com/shipilev/java-object-layout
 */
public class UnsafeUtils {

    public static void main(String[] args) {
        try {
            Unsafe unsafe = UnsafeUtils.getUnsafe();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式一：通过内置方法获取
     *
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = null;
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        unsafe = (Unsafe) field.get(null);
        return unsafe;
    }

    /**
     * 通过构造函数获取
     *
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     */

    public static Unsafe getUnsafeByConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
        unsafeConstructor.setAccessible(true);
        return unsafeConstructor.newInstance();
    }
}
