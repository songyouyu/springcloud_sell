package com.imooc.product.utils;

import com.imooc.product.VO.ResultVO;

/**
 * @author youyusong
 * @date 2018/10/18
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

}
