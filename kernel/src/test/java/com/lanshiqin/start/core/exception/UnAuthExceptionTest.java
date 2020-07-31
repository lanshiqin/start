package com.lanshiqin.start.core.exception;

import com.lanshiqin.start.core.constant.ResultCodeEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnAuthExceptionTest {

    @Test
    public void testGetResultCode() {
        String message = ResultCodeEnum.UN_AUTH_EXCEPTION.getDescribe();
        try {
            throw new UnAuthException(message);
        } catch (UnAuthException exception) {
            Assert.assertEquals(exception.getMessage(), message);
            Assert.assertEquals(exception.getResultCode(), ResultCodeEnum.UN_AUTH_EXCEPTION.getCode());
        }
    }
}