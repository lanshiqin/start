package com.lanshiqin.start.service.impl;

import com.lanshiqin.start.core.exception.BusinessException;
import com.lanshiqin.start.entity.User;
import com.lanshiqin.start.mapper.UserMapper;
import com.lanshiqin.start.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String addUser(final String name) {
        if (name == null) {
            throw new BusinessException("姓名不能为空");
        }
        User user = new User();
        String userId = UUID.randomUUID().toString();
        user.setName(name);
        user.setUserId(userId);
        userMapper.insert(user);
        return userId;
    }
}
