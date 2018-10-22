package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author youyusong
 * @date 2018/10/18
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 1.第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        log.info("response : {}", response);
//        return response;

        // 2.第二种方式
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance instance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", instance.getHost(), instance.getPort()) + "/msg";
//        String response = restTemplate.getForObject(url, String.class);
//        log.info("response : {}", response);
//        return response;

        // 3.第三种方式
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        log.info("response : {}", response);
//        return response;
        String msg = productClient.productMsg();
        log.info("response : {}", msg);
        return msg;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> order = productClient.listForOrder(Arrays.asList("123456", "123457"));
        log.info("response : {}", order);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("123456", 10)));
        return "ok";
    }

}
