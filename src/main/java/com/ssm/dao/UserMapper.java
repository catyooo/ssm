package com.ssm.dao;

import com.ssm.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登陆校验用户信息
     *
     * @param user
     * @return
     */
    User checkUserInfo(User user);
}