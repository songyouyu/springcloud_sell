package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收 mq 消息
 * @author youyusong
 * @date 2018/10/22
 */
@Slf4j
@Component
public class MqReceiver {

    // 1.@RabbitListener(queues = "myQueue")
    // 2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 3. 自动创建, Exchange 和 Queue 绑定
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange")))
//    public void process(String message) {
//        log.info("MqReceiver : {}", message);
//    }

    /**
     * 假设场景:
     * 数码供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            key = "computer",
            exchange = @Exchange("myOrder")))
    public void processComputer(String message) {
        log.info("Computer MqReceiver : {}", message);
    }

    /**
     * 假设场景:
     * 水果供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            key = "fruit",
            exchange = @Exchange("myOrder")))
    public void processFruit(String message) {
        log.info("Fruit MqReceiver : {}", message);
    }

}
