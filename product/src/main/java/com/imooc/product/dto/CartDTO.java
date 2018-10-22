package com.imooc.product.dto;

import lombok.Data;

/**
 * @author youyusong
 * @date 2018/10/18
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {

    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
