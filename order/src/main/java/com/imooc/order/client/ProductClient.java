package com.imooc.order.client;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author youyusong
 * @date 2018/10/18
 */
// fallback 指定如果产生服务降级, 访问到的实际的方法是哪些
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> decreaseStockInputList);

    @Component
    static class ProductClientFallback implements ProductClient {

        @Override
        public String productMsg() {
            return null;
        }

        @Override
        public List<ProductInfo> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<CartDTO> decreaseStockInputList) {

        }
    }

}
