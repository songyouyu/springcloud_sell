package com.imooc.user.service;

import com.imooc.user.dataobject.UserInfo;

/**
 * @author youyusong
 * @date 2018/10/24
 */
public interface UserService {

    /**
     * 通过 openid 查询用户
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
