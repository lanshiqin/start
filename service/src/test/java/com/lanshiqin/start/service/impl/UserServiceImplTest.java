package com.lanshiqin.start.service.impl;

import com.lanshiqin.start.mapper.UserMapper;
import com.lanshiqin.start.service.UserService;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServiceImplTest {

    private final UserService userServiceImpl = new UserServiceImpl(Mockito.mock(UserMapper.class));

    @Test
    public void testAddUser() {
        try{
            userServiceImpl.addUser(null);
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(), "姓名不能为空");
        }
        userServiceImpl.addUser("");
    }
}