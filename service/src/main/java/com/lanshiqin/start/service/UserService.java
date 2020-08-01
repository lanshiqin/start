package com.lanshiqin.start.service;

import com.lanshiqin.start.entity.User;

/**
 * 用户接口
 *
 * @author 蓝士钦
 */
public interface UserService {


    String addUser(String name);

    void deleteUser(String userId);

    User updateUser(String userId, String name);

    User findById(String userId);

}
