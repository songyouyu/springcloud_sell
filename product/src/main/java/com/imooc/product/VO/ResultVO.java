package com.imooc.product.VO;

import lombok.Data;

/**
 * @author youyusong
 * @date 2018/10/18
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
