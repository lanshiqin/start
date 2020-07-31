package com.lanshiqin.start.core.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * 对象工具单元测试
 *
 * @author 蓝士钦
 */
public class ObjectUtilTest {

    ObjectUtil objectUtil = new ObjectUtil();

    @Test
    public void testFieldConvertUnderline() throws IllegalAccessException {

        String userId = UUID.randomUUID().toString();
        String userName = "蓝士钦";
        Integer age = 25;
        Date createTime = new Date();
        String AZ = "AZ";

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setAge(age);
        user.setCreateTime(createTime);
        user.setAZ(AZ);
        Map<String, Object> userObject = objectUtil.fieldConvertUnderline(user);

        assertEquals(userObject.get("user_id"), userId);
        assertEquals(userObject.get("user_name"), userName);
        assertEquals(userObject.get("age"), age);
        assertEquals(userObject.get("create_time"), createTime);
        assertEquals(userObject.get("_a_z"), AZ);

        Map<String, Object> test2 = objectUtil.fieldConvertUnderline(new Object());
        Assert.assertEquals(test2, new HashMap<>());
    }

    @Test
    public void testTestFieldConvertUnderline() {
        Assert.assertEquals(objectUtil.camelCaseToUnderline("userId"), "user_id");
        Assert.assertEquals(objectUtil.camelCaseToUnderline("userName"), "user_name");
        Assert.assertEquals(objectUtil.camelCaseToUnderline("age"), "age");
        Assert.assertEquals(objectUtil.camelCaseToUnderline("createTime"), "create_time");
        Assert.assertEquals(objectUtil.camelCaseToUnderline("123"), "123");
        Assert.assertEquals(objectUtil.camelCaseToUnderline("AZ"), "_a_z");
    }

    static class User {
        private String userId;
        private String userName;
        private Integer age;
        private Date createTime;
        private String AZ;

        public void setUserId(final String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserName(final String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setAge(final Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public String getAZ() {
            return AZ;
        }

        public void setAZ(String AZ) {
            this.AZ = AZ;
        }
    }
}