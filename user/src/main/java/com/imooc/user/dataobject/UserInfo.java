package com.imooc.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author youyusong
 * @date 2018/10/24
 */
@Entity
@Data
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
