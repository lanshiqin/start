package com.lanshiqin.start.service.impl;

import com.lanshiqin.start.core.constant.ResultCodeEnum;
import com.lanshiqin.start.core.exception.BusinessException;
import com.lanshiqin.start.entity.User;
import com.lanshiqin.start.mapper.UserMapper;
import com.lanshiqin.start.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(final String name) {
        if (name == null) {
            throw new BusinessException(ResultCodeEnum.BUSINESS_EXCEPTION.getCode(), "姓名不能为空");
        }
        User user = new User();
        user.setName(name);
        userMapper.insert(user);
    }
}
