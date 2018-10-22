package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * @author youyusong
 * @date 2018/10/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void test() {
        List<ProductInfo> list = productService.findList(Arrays.asList("123456", "123457"));
        Assert.assertNotNull(list);
    }

    @Test
    public void testStock() {
        CartDTO cartDTO = new CartDTO("123457", 12);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }

}