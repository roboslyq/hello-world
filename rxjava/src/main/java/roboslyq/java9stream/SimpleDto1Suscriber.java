/**
 * Copyright (C), 2015-2019
 * FileName: SimpleDto1Suscriber
 * Author:   luo.yongqian
 * Date:     2019/5/6 17:42
 * Description: SimlpeDto1的订阅者
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2019/5/6 17:42      1.0.0               创建
 */
package roboslyq.java9stream;

import java.util.concurrent.Flow;

/**
 *
 * 〈SimlpeDto1的订阅者〉
 * @author luo.yongqian
 * @create 2019/5/6
 * @since 1.0.0
 */
public class SimpleDto1Suscriber implements Flow.Subscriber<SimpleDto1> {

    /**
     * 发布者和订阅者之间创建异步非阻塞链接。
     * 订阅者调用其request方法来向发布者请求项目。
     * 订阅者调用其cancel取消订阅的方法，即关闭发布者和订阅者之间的链接。
     */
    private Flow.Subscription subscription;

    /**
     * 订阅事件，这是订阅者订阅了发布者后接收消息时调用的第一个方法。
     * 通常我们调用subscription.request开始从处理器（Processor）接收项目
     * @param subscription
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("start subscription...");
        this.subscription = subscription;
        subscription.request(1);
    }

    /**
     * 当从发布者收到消息时调用此方法
     * @param item
     */
    @Override
    public void onNext(SimpleDto1 item) {
        System.out.println("simpleDto1 event--"+ item.getId() + "-"+ item.getName());
        subscription.request(1);
    }

    /**
     * 发生不可恢复的错误时调用此方法，我们可以在此方法中执行清理操作，例如关闭数据库连接。
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        System.out.println("error");
    }

    /**
     * 这就像finally方法，并且在发布者没有发布其他项目或发布者关闭时调用。
     * 我们可以用它来发送流成功处理的通知
     */
    @Override
    public void onComplete() {
        System.out.println("done");
    }
}