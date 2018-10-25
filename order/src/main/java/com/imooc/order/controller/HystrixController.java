package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * 服务容错
 * @author youyusong
 * @date 2018/10/25
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    /**
     * 当想调用的服务出错时, 会调用 fallback(), 达到服务降级
     * 也可以服务内部自己触发降级, 比如出现异常
     *
     * 超时时间设置 以及 服务熔断设置 也可以写在配置文件中
     * @return
     */

    // 配置超时时间
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })

    // 服务熔断
    @HystrixCommand(commandProperties = {

            /**
             * 每当 10 个请求中，有 60% 失败时，熔断器就会打开，此时再调用此服务，将会直接返回失败，不再调远程服务。
             * 直到 10s 钟之后，重新检测该触发条件，判断是否把熔断器关闭，或者继续打开。
             */

            // 设置熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 经过多长时间, 熔断器再次检查是否开启
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 错误率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    //(fallbackMethod = "fallback")
    @GetMapping("/getProductInfoList")
    public String getProductInfoList() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://localhost:8080/product/listForOrder",
                Arrays.asList("123456"), String.class);

//        throw new RuntimeException("出现异常了");
    }

    private String fallback() {
        return "出错啦, 请稍后再试 :)";
    }

    private String defaultFallback() {
        return "默认提示: 出错啦, 请稍后再试 :)";
    }

}
