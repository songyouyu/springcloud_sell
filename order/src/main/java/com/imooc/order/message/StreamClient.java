package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author youyusong
 * @date 2018/10/23
 */
public interface StreamClient {

    /*
     * Input 和 Output 不能重名, 和 springcloud 版本有关, 但是这样 mq 里面只有一个 Queue 的消息,
     * 生产上的话, 输入和输出不在同一个服务里即可重名
     * 需要选择自定义通道配置，需要后台配置文件绑定。
     */

    @Input("songMessage")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();

}
