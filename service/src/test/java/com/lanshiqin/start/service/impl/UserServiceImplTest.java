package com.lanshiqin.start.service.impl;

import com.lanshiqin.start.core.exception.BusinessException;
import com.lanshiqin.start.entity.User;
import com.lanshiqin.start.mapper.UserMapper;
import com.lanshiqin.start.service.UserService;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserServiceImplTest {

    private final UserMapper userMapper = Mockito.mock(UserMapper.class);
    private final UserService userService = new UserServiceImpl(userMapper);

    @DataProvider
    public Object[] testAddUserData() {
        Object[] data = new Object[2];
        data[0] = null;
        data[1] = "name";
        return data;
    }

    @Test(dataProvider = "testAddUserData")
    public void testAddUser(String name) {
        if (name != null) {
            String userIdActual = userService.addUser(name);
            Assert.assertNotNull(userIdActual);
        }

        if (name == null) {
            try {
                userService.addUser(null);
            } catch (BusinessException e) {
                Assert.assertEquals(e.getMessage(), "姓名不能为空");
            }
        }
    }

    @DataProvider
    public Object[] testDeleteUserData() {
        Object[] data = new Object[2];
        data[0] = null;
        data[1] = "userId";
        return data;
    }

    @Test(dataProvider = "testDeleteUserData")
    public void testDeleteUser(String userId) {
        try {
            userService.deleteUser(userId);
        } catch (BusinessException e) {
            Assert.assertEquals(e.getMessage(), "用户id不能为空");
        }
    }

    @DataProvider
    public Object[][] testUpdateUserData() {
        Object[][] data = new Object[2][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = "userId" + i;
            data[i][1] = "name" + i;
        }
        return data;
    }

    @Test(dataProvider = "testUpdateUserData")
    public void testUpdateUser(String userId, String name) {

        if (userId.equals("userId0")) {
            Mockito.when(userMapper.selectById("userId0")).thenReturn(new User());
            User user = userService.updateUser(userId, name);
            Assert.assertEquals(user.getName(), name);
        }

        if (userId.equals("userId1")) {
            Mockito.when(userMapper.selectById("userId1")).thenReturn(null);
            try {
                userService.updateUser(userId, name);
            } catch (BusinessException e) {
                Assert.assertEquals(e.getMessage(), "用户不存在");
            }
        }
    }

    @DataProvider
    public Object[] testFindByIdData() {
        Object[] data = new Object[2];
        data[0] = null;
        data[1] = "userId";
        return data;
    }


    @Test(dataProvider = "testFindByIdData")
    public void testFindById(String userId) {

        if (userId != null) {
            User MockUser = new User();
            MockUser.setUserId(userId);
            Mockito.when(userMapper.selectById(userId)).thenReturn(MockUser);
            User actualUser = userService.findById(userId);
            Assert.assertEquals(actualUser.getUserId(), userId);
        }

        if (userId == null) {
            try {
                userService.findById(null);
            } catch (BusinessException e) {
                Assert.assertEquals(e.getMessage(), "用户id不能为空");
            }
        }
    }
}