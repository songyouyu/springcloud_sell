package com.imooc.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author youyusong
 * @date 2018/10/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendFruit() {
        amqpTemplate.convertAndSend("myQueue", "now : " + new Date());
    }

    @Test
    public void sendComputer() {
        amqpTemplate.convertAndSend("myOrder","computer", "now : " + new Date());
    }



}
