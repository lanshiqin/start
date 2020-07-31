package com.lanshiqin.start.core.exception;

import com.lanshiqin.start.core.constant.ResultCodeEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SystemExceptionTest {

    @Test
    public void testGetResultCode() {
        String message = ResultCodeEnum.SYSTEM_EXCEPTION.getDescribe();
        try {
            throw new SystemException(message);
        } catch (SystemException exception) {
            Assert.assertEquals(exception.getMessage(), message);
            Assert.assertEquals(exception.getResultCode(), ResultCodeEnum.SYSTEM_EXCEPTION.getCode());
        }
    }
}