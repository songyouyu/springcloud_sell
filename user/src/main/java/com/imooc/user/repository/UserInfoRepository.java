package com.imooc.user.repository;

import com.imooc.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author youyusong
 * @date 2018/10/24
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * 根据 openid 查询
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
