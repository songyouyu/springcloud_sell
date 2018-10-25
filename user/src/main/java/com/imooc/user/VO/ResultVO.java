package com.imooc.user.VO;

import lombok.Data;

/**
 * @author youyusong
 * @date 2018/10/18
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
