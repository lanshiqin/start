package com.lanshiqin.start.core.base;

import com.lanshiqin.start.core.constant.ResultCodeEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class BaseResponseTest {

    @Test
    public void testGetResultCode() {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        Integer code = ResultCodeEnum.SUCCESS.getCode();
        baseResponse.setResultCode(code);
        Assert.assertEquals(baseResponse.getResultCode(), code);
    }

    @Test
    public void testSetResultCode() {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        Integer code = ResultCodeEnum.SUCCESS.getCode();
        baseResponse.setResultCode(code);
        Assert.assertEquals(baseResponse.getResultCode(), code);
    }

    @Test
    public void testGetResultMsg() {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        String message = "message Text";
        baseResponse.setResultMsg(message);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
    }

    @Test
    public void testSetResultMsg() {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        String message = "message Text";
        baseResponse.setResultMsg(message);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
    }

    @Test
    public void testGetData() {
        BaseResponse<Map<String, Object>> baseResponse = new BaseResponse<>();
        Map<String, Object> data = new HashMap<>();
        data.put("dataKey1", "dataValue1");
        Date date = new Date();
        data.put("dataKey2", date);
        baseResponse.setData(data);
        Assert.assertEquals(baseResponse.getData(), data);
        Assert.assertEquals(baseResponse.getData().get("dataKey1"), "dataValue1");
        Assert.assertEquals(baseResponse.getData().get("dataKey2"), date);
    }

    @Test
    public void testSetData() {
        BaseResponse<Map<String, Object>> baseResponse = new BaseResponse<>();
        Map<String, Object> data = new HashMap<>();
        data.put("dataKey1", "dataValue1");
        Date date = new Date();
        data.put("dataKey2", date);
        baseResponse.setData(data);
        Assert.assertEquals(baseResponse.getData(), data);
        Assert.assertEquals(baseResponse.getData().get("dataKey1"), "dataValue1");
        Assert.assertEquals(baseResponse.getData().get("dataKey2"), date);
    }

    @Test
    public void testResponse() {
        Integer code = ResultCodeEnum.SUCCESS.getCode();
        String message = "message Text";
        String data = "text Data";
        BaseResponse<String> baseResponse = BaseResponse.response(code, message, data);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        Assert.assertEquals(baseResponse.getData(), data);

    }

    @Test
    public void testSuccess() {
        Integer code = ResultCodeEnum.SUCCESS.getCode();
        String message = "message Text";
        BaseResponse<String> baseResponse = BaseResponse.success(message);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        Assert.assertNull(baseResponse.getData());
    }

    @Test
    public void testTestSuccess() {
        Integer code = ResultCodeEnum.SUCCESS.getCode();
        String message = "message Text";
        String data = "text Data";
        BaseResponse<String> baseResponse = BaseResponse.success(message, data);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        Assert.assertEquals(baseResponse.getData(), data);
    }

    @Test
    public void testList() {
        Integer code = ResultCodeEnum.SUCCESS.getCode();
        String message = "message Text";
        ListResult<UserTest> listResult = new ListResult<>();

        Long userId = 65535L;
        String userName = "蓝士钦";
        Integer age = 25;
        UserTest userTest = new UserTest();
        userTest.setUserId(userId);
        userTest.setUserName(userName);
        userTest.setAge(age);

        List<UserTest> userTestList = new ArrayList<>();
        userTestList.add(userTest);
        listResult.setRecords(userTestList);

        BaseResponse<ListResult<UserTest>> baseResponse = BaseResponse.list(message, listResult);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        UserTest actualUserTest = baseResponse.getData().getRecords().get(0);
        Assert.assertEquals(actualUserTest.getUserId(), userId);
        Assert.assertEquals(actualUserTest.getUserName(), userName);
        Assert.assertEquals(actualUserTest.getAge(), age);
    }

    @Test
    public void testFail() {
        Integer code = ResultCodeEnum.BUSINESS_EXCEPTION.getCode();
        String message = "message Text";
        BaseResponse<String> baseResponse = BaseResponse.fail(message);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        Assert.assertNull(baseResponse.getData());
    }

    @Test
    public void testTestFail() {
        Integer code = ResultCodeEnum.BUSINESS_EXCEPTION.getCode();
        String message = "message Text";

        Long userId = 65535L;
        String userName = "蓝士钦";
        Integer age = 25;
        UserTest userTest = new UserTest();
        userTest.setUserId(userId);
        userTest.setUserName(userName);
        userTest.setAge(age);

        BaseResponse<UserTest> baseResponse = BaseResponse.fail(message, userTest);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        Assert.assertEquals(baseResponse.getData(), userTest);
        Assert.assertEquals(baseResponse.getData().getUserId(), userId);
        Assert.assertEquals(baseResponse.getData().getUserName(), userName);
        Assert.assertEquals(baseResponse.getData().getAge(), age);
    }

    @Test
    public void testError() {
        Integer code = ResultCodeEnum.SYSTEM_EXCEPTION.getCode();
        String message = "message Text";

        Long userId = 65535L;
        String userName = "蓝士钦";
        Integer age = 25;
        UserTest userTest = new UserTest();
        userTest.setUserId(userId);
        userTest.setUserName(userName);
        userTest.setAge(age);

        BaseResponse<UserTest> baseResponse = BaseResponse.error(message, userTest);
        Assert.assertEquals(baseResponse.getResultCode(), code);
        Assert.assertEquals(baseResponse.getResultMsg(), message);
        Assert.assertEquals(baseResponse.getData(), userTest);
        Assert.assertEquals(baseResponse.getData().getUserId(), userId);
        Assert.assertEquals(baseResponse.getData().getUserName(), userName);
        Assert.assertEquals(baseResponse.getData().getAge(), age);
    }

    static class UserTest {
        private Long userId;
        private String userName;
        private Integer age;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(final Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(final String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(final Integer age) {
            this.age = age;
        }
    }
}