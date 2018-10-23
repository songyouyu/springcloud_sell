package com.imooc.order.message;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author youyusong
 * @date 2018/10/23
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        log.info("message : {}", message);
        // message --> productInfo
        List<ProductInfo> productInfoList = JsonUtil.string2Obj(message,
                new TypeReference<List<ProductInfo>>() {});
        log.info("从消息队列接收到的消息 : {}", productInfoList);

        // 存储到 redis 中
        for (ProductInfo productInfo : productInfoList) {
            stringRedisTemplate.opsForValue().set(
                    String.format(PRODUCT_STOCK_TEMPLATE, productInfo.getProductId()),
                    String.valueOf(productInfo.getProductStock()));
        }
    }

}
