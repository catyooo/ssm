package com.ssm.service;


import com.ssm.entity.User;

public interface IUserService {

    User getUserById(String id);

    int insertSelective(User user);

    /**
     * 登陆校验用户信息
     * @param user
     * @return
     */
    User checkUserInfo(User user);
}

