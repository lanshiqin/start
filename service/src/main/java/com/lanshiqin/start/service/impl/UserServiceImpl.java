package com.lanshiqin.start.service.impl;

import com.lanshiqin.start.core.constant.ResultCodeEnum;
import com.lanshiqin.start.core.exception.BusinessException;
import com.lanshiqin.start.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String name) {
        if (name == null) {
            throw new BusinessException(ResultCodeEnum.BUSINESS_EXCEPTION.getCode(), "姓名不能为空");
        }
    }
}
