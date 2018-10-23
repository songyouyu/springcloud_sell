package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author youyusong
 * @date 2018/10/23
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener("myMessage")
//    public void process(Object message) {
//        log.info("StreamReceiver : {}", message);
//    }

    @StreamListener("myMessage")
//    @SendTo  消费完消息后进行回复
    public void process(OrderDTO message) {
        log.info("StreamReceiver : {}", message);
    }

}
